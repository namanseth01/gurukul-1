/*   Created by IntelliJ IDEA.
 *   Author: Devvrat Sharma (devrats)
 *   Date: 30-Jul-21
 *   Time: 2:08 PM
 *   File: Email.java
 */

package com.example.gurukul.email;

public class Email {


    private String head2;
    private String msg1;

    public String getMsg1() {
        return msg1;
    }

    public Email() {
    }

    public String getHead2() {
        return "Please verify Your Gurukul Account";
    }

    public String getMsg1(String otp) {
        return "To verify your email address, please use the following One Time Password (OTP):\n" +
                "\n" +
                otp + "\n" +
                "\n" +
                "Do not share this OTP with anyone." + "\nGurukul takes your account security very seriously. Gurukul Customer Service will never ask you to disclose or verify your Gurukul password, OTP, credit card, or banking account number. If you receive a suspicious email with a link to update your account information, do not click on the link—instead, report the email to Gurukul for investigation.\n" +
                "\n" +
                "Thank you!\n" +
                "\n";
    }
}