package com.example.mastermapper;
import com.example.domain.TestPOJO;

import java.util.List;

public interface MasterMapper {

    public List<TestPOJO> get(Integer age);
    public void add();
}
