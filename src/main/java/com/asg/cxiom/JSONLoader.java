package com.asg.cxiom;

import com.asg.cxiom.model.Mobile;
import com.asg.cxiom.services.MobileService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;

@Component
public class JSONLoader {

    @Autowired
    MobileService mobileService;

    @PostConstruct
    public void loadData(){
        String jsonData = readFileFromResources("Mobile_database.json");
        System.out.println("In data loading..."+ jsonData);

        Gson gson = new Gson();

        Mobile[] mobileArray = gson.fromJson(jsonData, Mobile[].class);
        try {
            mobileService.importAllPhones(mobileArray);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private String readFileFromResources(String fileName)  {
        URL resource = this.getClass().getClassLoader().getResource(fileName);
        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get(resource.toURI()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new String(bytes);

    }
}
