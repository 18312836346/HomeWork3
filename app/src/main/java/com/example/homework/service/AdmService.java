package com.example.homework.service;


import com.example.homework.model.AdmCount;
import com.example.homework.model.AdmInfo;

public interface AdmService {

    public void insert(AdmCount admCount);
    public void insert(AdmInfo admInfo);

    public void delete(AdmCount admCount);
    public void delete(AdmInfo admInfo);

    public void modify(AdmCount admCount);
    public void modify(AdmInfo admInfo);

    public AdmCount selectAdmCout(String name);
    public AdmInfo selectAdmInfo(String name);



}
