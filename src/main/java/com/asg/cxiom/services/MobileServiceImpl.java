package com.asg.cxiom.services;

import com.asg.cxiom.entity.MobileEntity;
import com.asg.cxiom.model.Mobile;
import com.asg.cxiom.model.MobileData;
import com.asg.cxiom.repository.MobileRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MobileServiceImpl implements  MobileService {

    @Autowired
    private MobileRepository repository;

    @Override
    public List<MobileData> searchByPrice(String euroPrice){
        List<MobileData> mobiles = new ArrayList<MobileData>();
        List<MobileEntity> searchList = repository.findMobileEntityByPrice(euroPrice);

        if(searchList != null) {
            for(MobileEntity entity : searchList) {
                mobiles.add(convetToMobileData(entity));
            }
        }

        return mobiles;
    }

    @Override
    public List<MobileData> searchBySim(String simType){
        List<MobileData> mobiles = new ArrayList<MobileData>();
        List<MobileEntity> searchList = repository.findMobileEntityBySIM(simType);

        if(searchList != null) {
            for(MobileEntity entity : searchList) {
                mobiles.add(convetToMobileData(entity));
            }
        }

        return mobiles;
    }

    @Override
    public List<MobileData> searchByAnnouceDateByPrice(String annouceDateYear, String euroPrice){
        List<MobileData> mobiles = new ArrayList<MobileData>();
        List<MobileEntity> searchList = repository.findMobileEntityByReleaseAnnounceDateByPrice(annouceDateYear, euroPrice);

        if(searchList != null) {
            for(MobileEntity entity : searchList) {
                mobiles.add(convetToMobileData(entity));
            }
        }

        return mobiles;
    }


    private MobileData convetToMobileData(MobileEntity phone) {
        MobileData mobile;
        mobile = new MobileData();
        mobile.setId(phone.getId());
        mobile.setBrand(phone.getBrand());
        mobile.setPhone(phone.getPhone());
        mobile.setPicture(phone.getPicture());
        mobile.setSim(phone.getSim());
        mobile.setResolution(phone.getResolution());
        mobile.setHardwareAudioJack(phone.getHardwareAudioJack());
        mobile.setHardwareBattery(phone.getHardwareBattery());
        mobile.setHardwareGps(phone.getHardwareGps());
        mobile.setReleaseAnnounceDate(phone.getReleaseAnnounceDate());
        mobile.setReleasePriceEur(phone.getReleasePriceEur());
        return mobile;
    }

    @Override
    public void importAllPhones(Mobile[] phones) throws ParseException {

        if(phones == null || phones.length < 1) return;

        SimpleDateFormat format = new SimpleDateFormat("dd yyyy MMMM");
        List<MobileEntity> mobiles = new ArrayList<MobileEntity>();
        MobileEntity objMobileEntity;
        for(Mobile phone : phones){
            objMobileEntity = new MobileEntity();
            objMobileEntity.setBrand(phone.getBrand());
            objMobileEntity.setPhone(phone.getPhone());
            objMobileEntity.setPicture(phone.getPhone());
            objMobileEntity.setResolution(phone.getResolution());
            objMobileEntity.setSim(phone.getSim());
            objMobileEntity.setReleaseAnnounceDate(phone.getRelease().getAnnounceDate());
            objMobileEntity.setReleasePriceEur(phone.getRelease().getPriceEur());
            objMobileEntity.setHardwareAudioJack(phone.getHardware().getAudioJack());
            objMobileEntity.setHardwareBattery(phone.getHardware().getBattery());
            objMobileEntity.setHardwareGps(phone.getHardware().getGps());

            mobiles.add(objMobileEntity);
        }
        repository.saveAll(mobiles);
    }
}
