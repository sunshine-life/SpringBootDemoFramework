package com.example.webcrawler;

import com.example.mongo.model.products.P2P;
import com.example.mongo.model.products.Products;
import net.sf.json.xml.XMLSerializer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by life on 17-1-9.
 */
public class P2PMain {

    public static void main(String[] args) {
        try {
            List<Products> list = new ArrayList<>();

            String url = "https://www.rong360.com/licai-p2p/list/";

            Document doc = (Document) Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").get();
            Elements elements =  doc.getElementsByClass("loan-search-l");
            Element temp =elements.get(0);
            //获取到table下所有的节点以便获取table
            Elements childElements = temp.children();
            for(int i=0;i<childElements.size();i++){

               Element child =  childElements.get(i);


                //获取到table节点后开始获取tbody节点
                if(child.tagName().equals("table")){


                    Elements tbodyElements = child.children();
                    for(int j=0;j<tbodyElements.size();j++){


                        Element tbody =  tbodyElements.get(j);


                        //获取到table节点后开始获取tbody节点
                       if(tbody.tagName().equals("tbody"))
                       {
                           //获取到tbody节点下所有的tr节点
                           Elements trdoc =  tbody.children();
                           //开始遍历所有的tr节点
                           for(int n=0;n<trdoc.size();n++){

                               Products tempPro = new Products();

                               String childPageUrl = null;
                               Element trbody = trdoc.get(n);
                               //获取所有拥有sub子节点的Element
                               if(trbody.className().equals("sub")){
                                   //获取到所有的含有相似产品的集合
                                   Elements subBody = trbody.children();
                                   Element subTemp = subBody.get(0);
                                   //获取sub的td节点，然后获取td节点的table节点，然后获取table节点的tbody节点，并取第一个
                                   Elements tdBody = subTemp.children();
                                   Element urlTemp =  tdBody.get(1).child(0).child(0);
                                   XMLSerializer xmlSerializer = new XMLSerializer();
                                   net.sf.json.JSONObject json = (net.sf.json.JSONObject) xmlSerializer.read(urlTemp.toString());
                                   childPageUrl = (String)json.get("@click-url");
                                   //开始解析真实产品详情页面
                                   readProPage(childPageUrl,tempPro);
                                   list.add(tempPro);
                                   continue;
                               }
                               //获取没有相似产品的数据
                               if(trbody.className().equals("twotr")){
                                   XMLSerializer xmlSerializer = new XMLSerializer();
                                   String xml = trbody.toString().replace("&nbsp;", ' ' + "");
                                   net.sf.json.JSONObject json = (net.sf.json.JSONObject) xmlSerializer.read(xml);
                                   childPageUrl = (String)json.get("@click-url");
                                   //开始解析真实产品详情页面
                                   readProPage(childPageUrl,tempPro);
                                   list.add(tempPro);
                                   continue;
                               }

                           }

                       }


                    }
                }
            }
            System.out.println("遍历结束");
            System.out.println(list.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 爬取产品详情页
     * @param url
     */
    public static void readProPage(String url,Products pro){
        Document doc = null;
        P2P p2p = new P2P();
        XMLSerializer xmlSerializer = new XMLSerializer();
        try {
            doc = (Document) Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").get();
            Elements elements =  doc.getElementsByClass("view-l-des");
            System.out.println("======================================================================================");
            System.out.println("产品URL："+url);
            String[] urls = url.split("-");
            System.out.println("产品编号为："+urls[urls.length-1]);
            //获取tab1-----------------------------
            Element desc = elements.get(0);
            //查询class为t的div，获取产品名称
            Element name = desc.child(0);
            String proName = name.child(0).text().split(" ")[0].trim();
            System.out.println("产品名称为:"+proName);


            //查询class为d的div，获取产品年化收益,投资周期,剩余额度
            Element div2 = desc.child(1);
            String yield = div2.child(0).child(0).text().trim();
            System.out.println("产品年华收益为:"+yield);
            String investDays = div2.child(1).child(0).text().trim();
            System.out.println("投资周期为:"+investDays);
            String leftAmount = div2.child(2).child(0).text().trim();
            System.out.println("剩余额度为:"+leftAmount);

            float result=new Float(yield.substring(0,yield.indexOf("%")))/100;
            BigDecimal   b   =   new   BigDecimal(result);

            //对于期望收益率百分数转为小数，保留小数点后四位
            b = b.setScale(4,   BigDecimal.ROUND_HALF_UP);

            pro.setExcepteYield(b);
            pro.setInvestDays(Integer.parseInt(investDays));
            pro.setLeftAmount(new BigDecimal(leftAmount.substring(0,leftAmount.length()-1)));



            //查询calss为c clearfix的节点，获取子table-tbody,遍历tr,获取借款总额,还款方式,起投金额,资金保障,购买地址
            Element div3 = desc.child(2);
            Elements trs = div3.child(0).child(0).children();
            String totalAmount = null;
            String rePayWays = null;
            String investMin = null;
            String investProtect = null;
            String urlToBuy = null;
            for(int i=0;i<trs.size();i++){
                Element trTemp = trs.get(i);
                if(i==1){
                    totalAmount = trTemp.child(1).text().trim();
                    pro.setTotalAmount(new BigDecimal(totalAmount.substring(0,totalAmount.length()-1)));
                }else if(i==2){
                    rePayWays = trTemp.child(1).text().trim().replace("    ","");
                    pro.setRepaymentWay(rePayWays);
                }else if(i==3){
                    investMin = trTemp.child(1).text().trim();
                    pro.setInvestMin(new BigDecimal(investMin.substring(0,investMin.length()-1)));
                }else if(i==4){
                    investProtect = trTemp.child(1).text().trim();
                    p2p.setP2pProtection(investProtect);
                }else if(i==5){
                    String xml = trTemp.child(0).child(0).toString().replace("&nbsp;", ' ' + "");
                    net.sf.json.JSONObject json = (net.sf.json.JSONObject) xmlSerializer.read(xml);
                    urlToBuy = (String)json.get("@href");
                    pro.setUrlToBuy(urlToBuy);
                }
            }
            System.out.println("借款总额为:"+totalAmount);
            System.out.println("还款方式为:"+rePayWays);
            System.out.println("起投金额为:"+investMin);
            System.out.println("资金保障为:"+investProtect);
            System.out.println("购买地址为:"+urlToBuy);


            //获取tab2-----------------------------
            //查询tab2的table节点，获取子节点tbody,遍历tr,获取充值费,管理费,提现费,VIP费
            Element tbody = div3.child(1).child(0).child(0);
            Elements tab2Trs = tbody.children();
            String rechargeCost = null;
            String withdrawCost = null;
            String  ManagerCost = null;
            String  VIPCost = null;
            for(int i=0;i<tab2Trs.size();i++){
                Element trTemp = tab2Trs.get(i);
                if(i==0){
                    rechargeCost = trTemp.child(1).text().trim();
                    pro.setRechargeCost(rechargeCost);
                }else if(i==1){
                    ManagerCost = trTemp.child(1).text().trim().replace("    ","");
                    pro.setManagerCost(ManagerCost);
                }else if(i==2){
                    withdrawCost = trTemp.child(1).text().trim();
                    pro.setWithdrawCost(withdrawCost);
                }else if(i==3){
                    VIPCost = trTemp.child(1).text().trim();
                    p2p.setVIPCost(VIPCost);
                }
            }
            System.out.println("充值费为:"+rechargeCost);
            System.out.println("管理费为:"+ManagerCost);
            System.out.println("提现费为:"+withdrawCost);
            System.out.println("VIP费为:"+VIPCost);

            //获取平台详情页
            Elements relements =  doc.getElementsByClass("view-r-des");
            //获取view-l-des节点下的a标签的字节点，获取平台详情页的url
            Element  rUrl = relements.get(0).children().get(2);
            String xml = rUrl.toString().replace("&nbsp;", ' ' + "");
            net.sf.json.JSONObject json = (net.sf.json.JSONObject) xmlSerializer.read(xml);
            String issureUrl = (String)json.get("@href");
            System.out.println("机构详情地址为："+issureUrl);
            pro.setIssuerUrl(issureUrl);
            pro.setP2p(p2p);
            readIssurePage(issureUrl,pro);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 爬取平台详情页
     * @param url
     */
    public static void readIssurePage(String url,Products pro){
        Document doc = null;
        XMLSerializer xmlSerializer = new XMLSerializer();
        try {
            doc = (Document) Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").get();
            //查询class为loan-des wrap-clear下的div的数据,获取注册资金,上线时间,平台网址,起投金额,平台背景,风险准备金,资金托管
            Element desc = null;
            Elements decElements = doc.getElementsByClass("loan-des");
            desc = decElements.get(0);
            Element wrapLeft = desc.child(0);
            //遍历wrapLeft的所有p节点的text
            Elements pElments = wrapLeft.children();
            String registMoney;
            String issuerDate;
            String issuerLocation;
            String issuerUrl;

            for(int a=0;a<pElments.size();a++){
                if(a==1){
                    registMoney = pElments.get(1).text().trim();
                    System.out.println("注册资金为："+registMoney);
                    pro.getP2p().setRegistMoney(registMoney);
                }else if(a==3){
                    issuerDate = pElments.get(3).text().trim().replace("    ","");
                    System.out.println("上线时间为："+issuerDate);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
                    pro.setIssuerDate(sdf.parse(issuerDate));
                }else if(a==5){
                    issuerLocation = pElments.get(5).text().trim();
                    System.out.println("所在地区为："+issuerLocation);
                    pro.setIssuerLocation(issuerLocation);
                }else if(a==7){
                    Element  rUrl = pElments.get(7).child(0);
                    String xml = rUrl.toString().replace("&nbsp;", ' ' + "");
                    net.sf.json.JSONObject json = (net.sf.json.JSONObject) xmlSerializer.read(xml);
                    issuerUrl = (String)json.get("@href");
                    System.out.println("平台网址为："+issuerUrl);
                    pro.setIssuerLocation(issuerUrl);
                }
            }


            Element wrapRight = decElements.get(0).child(1);
            //遍历wrapLeft的所有p节点的text
            Elements pRightElments = wrapRight.children();
            String issurerDesc;
            String prepareAmount;
            String trusteeShip;
            for(int a=0;a<pRightElments.size();a++){
                if(a==1){
                    issurerDesc = pRightElments.get(1).text().trim();
                    System.out.println("平台背景："+issurerDesc);
                    pro.setIssuerDesc(issurerDesc);
                }else if(a==3){
                    prepareAmount = pRightElments.get(3).text().trim().replace("    ","");
                    System.out.println("风险准备金："+prepareAmount);
                    pro.getP2p().setPrepareAmount(prepareAmount);
                }else if(a==5){
                    trusteeShip = pRightElments.get(5).text().trim();
                    System.out.println("资金管理："+trusteeShip);
                    pro.getP2p().setTrusteeShip(trusteeShip);
                }
            }

            //获取平台介绍
            Elements msgElements = doc.getElementsByClass("loan-msg-cons");
            StringBuffer msgtemp = new StringBuffer();
            if(msgElements.size()!=0){
                Element msg = msgElements.get(0).child(0);
                Elements msgs = msg.children();
                for(int c=0;c<msgs.size();c++){
                    Element msgText = msgs.get(c);
                    if(!msgText.text().equals("")){
                        msgtemp = msgtemp.append(msgText.text()).append("/");
                    }
                }
            }else{
                msgtemp.append("暂无平台介绍");
            }
            pro.setIssuerDesc(msgtemp.toString());
            //获取机构图片与机构名称
            //获取平台介绍
            String issureImg;
            Elements elements = doc.getElementsByClass("loan-name");
            Element imgElement = elements.get(0);
            //从warp-left获取图片地址
            Element left = imgElement.child(0);
            Element img = left.child(0).child(0);
            String xml = img.toString().replace("&nbsp;", ' ' + "")+"</img>";
            net.sf.json.JSONObject json = (net.sf.json.JSONObject) xmlSerializer.read(xml);
            issureImg = (String) json.get("@src");
            System.out.println("平台图片为:"+issureImg);
            pro.setImgSrc(issureImg);
            //获取平台名字
            String name = imgElement.child(1).child(0).child(0).text();
            System.out.println("机构名称为："+name);



            //获取平台评级
            String issureLevel = imgElement.child(2).child(0).child(0).text();
            if(issureLevel.equals("")){
                issureLevel = "无";
            }
            System.out.println("平台评级为："+issureLevel);
            pro.getP2p().setIssurerLevel(issureLevel);
            System.out.println("平台介绍为："+msgtemp);
            System.out.println("======================================================================================");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
