package com.jcd.model;

import lombok.Data;

import java.util.List;

@Data
public class ResultPo {

   private String usernumber;
   private List<PdaLineCylinderMatRel> materials;
   private String pdaLineCode;
   private String pdaCylinderCode;

}
