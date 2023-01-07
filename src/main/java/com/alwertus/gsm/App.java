package com.alwertus.gsm;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        PhoneGsmService gsm = new PhoneGsmService();
        String[] ports = gsm.getSystemPorts();
        for (String port : ports) {
            System.out.println(port);
        }
        gsm.initialize("ttyUSB0");

//        gsm.executeAT("AT^GETPORTMODE", 3);
//        gsm.executeAT("ATI", 3);
//        gsm.sendSms("+79199659505", "hihi");
//        gsm.sendSms("+79199659505", "хихи");

        ArrayList<PhoneSms> sms = gsm.readSms();
        for (PhoneSms s : sms) { // list all the available ports
            System.out.println(s);
        }

//        gsm.deleteAllSms(Gsm.SmsStorage[0]);

        gsm.closePort();
    }

}
