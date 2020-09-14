package com.asg.cxiom.services;

import com.asg.cxiom.model.Mobile;
import com.asg.cxiom.model.MobileData;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface MobileService {

    public List<MobileData> searchByPrice(String priceEuro);

    public List<MobileData> searchBySim(String sim);

    public List<MobileData> searchByAnnouceDateByPrice(String announceDateYear, String param);

    public void importAllPhones(Mobile[] phones) throws ParseException;

    }
