package org.sid.billingservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ConsulConfigRestController {

@Autowired
    private MyConsulConfig myConsulConfig;
    @Autowired
   private MyVaultConfig myVaultConfig;


//    @Value("${token.accessTokenTimeout}")
//    private long  accessTokenTimeout;
//
//    @Value("${token.refreshTokenTimeout}")
//    private long  refreshTokenTimeout;


    @GetMapping("/ConsulConfig")
    public MyConsulConfig myConfig(){

   return myConsulConfig; }

    @GetMapping("/VaultConfig")
    public MyVaultConfig vaultConfig(){

        return myVaultConfig; }

    @GetMapping("/MyConfig")
    public Map<String,Object> Allconfig(){

        return Map.of("ConsulConfig",myConsulConfig,"vaultConfig",myVaultConfig); }












}
