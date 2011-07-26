package com.personnelmanager.service;

import org.apache.commons.codec.DecoderException;
import org.jmock.integration.junit4.JMock;
import org.junit.Before;
import org.junit.Test;
import org.apache.commons.codec.net.URLCodec;

import java.net.URLEncoder;

/**
 * Jmock test for PersonnelService
 * User: MikeChen
 * Date: Nov 23, 2010
 * Time: 5:49:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class PersonnelServiceTest {
    private JMock personDao;

    @Before
    public void init() {
    }

    @Test
    public void testSavePerson() {

    }
    @Test
    public void testDecodeUrl() {
        URLCodec codec = new URLCodec();
        try {
            String result = codec.decode("MjAyMjFfMS1fNDAyMjFfMTA5MDFfMTUwMDFfMXlyb2dldGFjL3RlbHZyZXMvc2Vyb3RzL3Njdy9w%0AcGFiZXcvbW9jLmVpYm1vcmNyZWJhLnd3dy8vOnNwdHRo%0A");
            System.out.println(result);
        } catch (DecoderException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
