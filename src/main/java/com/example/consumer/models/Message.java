package com.example.consumer.models;
 import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
 import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */

public class Message {

    @JsonProperty("SrcAddr")
    public String srcAddr;
    @JsonProperty("DstAddr")
    public String dstAddr;
    @JsonProperty("SrcPort")
    public int srcPort;
    @JsonProperty("DstPort")
    public int dstPort;
    @JsonProperty("InIf")
    public int inIf;
    @JsonProperty("OutIf")
    public int outIf;
    @JsonProperty("SrcMac")
    public String srcMac;
    @JsonProperty("DstMac")
    public String dstMac;

    public String getSrcAddr() {
        return srcAddr;
    }

    public void setSrcAddr(String srcAddr) {
        this.srcAddr = srcAddr;
    }

    public String getDstAddr() {
        return dstAddr;
    }

    public void setDstAddr(String dstAddr) {
        this.dstAddr = dstAddr;
    }

    public int getSrcPort() {
        return srcPort;
    }

    public void setSrcPort(int srcPort) {
        this.srcPort = srcPort;
    }

    public int getDstPort() {
        return dstPort;
    }

    public void setDstPort(int dstPort) {
        this.dstPort = dstPort;
    }

    public int getInIf() {
        return inIf;
    }

    public void setInIf(int inIf) {
        this.inIf = inIf;
    }

    public int getOutIf() {
        return outIf;
    }

    public void setOutIf(int outIf) {
        this.outIf = outIf;
    }

    public String getSrcMac() {
        return srcMac;
    }

    public void setSrcMac(String srcMac) {
        this.srcMac = srcMac;
    }

    public String getDstMac() {
        return dstMac;
    }

    public Message() {
    }

    public void setDstMac(String dstMac) {
        this.dstMac = dstMac;
    }
}
