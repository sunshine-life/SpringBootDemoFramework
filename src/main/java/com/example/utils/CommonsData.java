package com.example.utils;

/**
 * Created by life on 16-10-12.
 */
public class CommonsData {

    public interface common{
        String getValue();
    }

    public interface commonInt{
        int getValue();
    }

    public static enum son implements common{

        SON1("son1",123),
        SON2("son2",123),
        SON3("son3",123),
        ;
        private String name;
        private int mun;
        son(String string,int mun){
            this.name = string;
            this.mun = mun;
        }
        @Override
        public String getValue() {
            return this.name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getMun() {
            return mun;
        }

        public void setMun(int mun) {
            this.mun = mun;
        }

        @Override
        public String toString() {
            return "son{" +
                    "name='" + name + '\'' +
                    ", mun=" + mun +
                    '}';
        }
    }

    public static  enum TenderStatus implements commonInt{
        ON(1),
        COMPLET(2),
        END(3),
        ;
        TenderStatus(int status){
            this.status = status;
        }
        private int status;

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        @Override
        public int getValue() {
            return this.status;
        }
    }


}
