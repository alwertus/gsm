package com.alwertus.gsm;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("ttyUSB# is not determine");
            return;
        }

        PhoneGsmService gsm = new PhoneGsmService();
        String[] ports = gsm.getSystemPorts();
        for (String port : ports) {
            System.out.println(port);
        }
        gsm.initialize("ttyUSB" + args[0]);

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
