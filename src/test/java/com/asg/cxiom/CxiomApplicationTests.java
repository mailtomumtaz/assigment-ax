package com.asg.cxiom;

import com.asg.cxiom.services.MobileService;
import com.asg.cxiom.services.MobileServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CxiomApplicationTests {

	@Autowired
	MobileServiceImpl service;

	@Test
	void testSearchMobileByPrice(){
		List searchList = service.searchByPrice("200");
		Assert.assertEquals(10, searchList.size());
	}

	@Test
	void testSearchMobileBySIM(){
		List searchList = service.searchBySim("eSIM");
		Assert.assertEquals(18, searchList.size());
	}

	@Test
	void testSearchMobileAnnouceYearByPrice(){
		List searchList = service.searchByAnnouceDateByPrice("1999", "200");
		Assert.assertEquals(2, searchList.size());
	}

}
