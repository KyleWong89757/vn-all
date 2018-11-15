package com.ms.vn.vndao.model;

import java.io.Serializable;
import java.util.Date;

public class GxHappyTen  implements Serializable {

    private static final long serialVersionUID = 8546818294391453293L;

    private Long id;

    private Integer drawCount;

    private Long drawIssue;

    private Date drawTime;

    private Integer enable;

    private String preDrawCode;

    private Date preDrawDate;

    private Long preDrawIssue;

    private Date preDrawTime;

    private Integer alarmStatus;

    private String codeSource;

    private Date createTime;

    private Integer drawStatus;

    private Integer nextDrawIssueStatus;

    private Date overDrawTime;

    private Date prepareDrawTime;

    private Date updateTime;

    private Integer firstDragonTiger;

    private Integer lastBigSmall;

    private Integer sumBigSmall;

    private Integer sumNum;

    private Integer sumSingleDouble;

    private Integer ignoreAnalysisFlag;

    public GxHappyTen(Long id, Integer drawCount, Long drawIssue, Date drawTime, Integer enable, String preDrawCode, Date preDrawDate, Long preDrawIssue, Date preDrawTime, Integer alarmStatus, String codeSource, Date createTime, Integer drawStatus, Integer nextDrawIssueStatus, Date overDrawTime, Date prepareDrawTime, Date updateTime, Integer firstDragonTiger, Integer lastBigSmall, Integer sumBigSmall, Integer sumNum, Integer sumSingleDouble, Integer ignoreAnalysisFlag) {
        this.id = id;
        this.drawCount = drawCount;
        this.drawIssue = drawIssue;
        this.drawTime = drawTime;
        this.enable = enable;
        this.preDrawCode = preDrawCode;
        this.preDrawDate = preDrawDate;
        this.preDrawIssue = preDrawIssue;
        this.preDrawTime = preDrawTime;
        this.alarmStatus = alarmStatus;
        this.codeSource = codeSource;
        this.createTime = createTime;
        this.drawStatus = drawStatus;
        this.nextDrawIssueStatus = nextDrawIssueStatus;
        this.overDrawTime = overDrawTime;
        this.prepareDrawTime = prepareDrawTime;
        this.updateTime = updateTime;
        this.firstDragonTiger = firstDragonTiger;
        this.lastBigSmall = lastBigSmall;
        this.sumBigSmall = sumBigSmall;
        this.sumNum = sumNum;
        this.sumSingleDouble = sumSingleDouble;
        this.ignoreAnalysisFlag = ignoreAnalysisFlag;
    }

    public GxHappyTen() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDrawCount() {
        return drawCount;
    }

    public void setDrawCount(Integer drawCount) {
        this.drawCount = drawCount;
    }

    public Long getDrawIssue() {
        return drawIssue;
    }

    public void setDrawIssue(Long drawIssue) {
        this.drawIssue = drawIssue;
    }

    public Date getDrawTime() {
        return drawTime;
    }

    public void setDrawTime(Date drawTime) {
        this.drawTime = drawTime;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public String getPreDrawCode() {
        return preDrawCode;
    }

    public void setPreDrawCode(String preDrawCode) {
        this.preDrawCode = preDrawCode == null ? null : preDrawCode.trim();
    }

    public Date getPreDrawDate() {
        return preDrawDate;
    }

    public void setPreDrawDate(Date preDrawDate) {
        this.preDrawDate = preDrawDate;
    }

    public Long getPreDrawIssue() {
        return preDrawIssue;
    }

    public void setPreDrawIssue(Long preDrawIssue) {
        this.preDrawIssue = preDrawIssue;
    }

    public Date getPreDrawTime() {
        return preDrawTime;
    }

    public void setPreDrawTime(Date preDrawTime) {
        this.preDrawTime = preDrawTime;
    }

    public Integer getAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(Integer alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    public String getCodeSource() {
        return codeSource;
    }

    public void setCodeSource(String codeSource) {
        this.codeSource = codeSource == null ? null : codeSource.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDrawStatus() {
        return drawStatus;
    }

    public void setDrawStatus(Integer drawStatus) {
        this.drawStatus = drawStatus;
    }

    public Integer getNextDrawIssueStatus() {
        return nextDrawIssueStatus;
    }

    public void setNextDrawIssueStatus(Integer nextDrawIssueStatus) {
        this.nextDrawIssueStatus = nextDrawIssueStatus;
    }

    public Date getOverDrawTime() {
        return overDrawTime;
    }

    public void setOverDrawTime(Date overDrawTime) {
        this.overDrawTime = overDrawTime;
    }

    public Date getPrepareDrawTime() {
        return prepareDrawTime;
    }

    public void setPrepareDrawTime(Date prepareDrawTime) {
        this.prepareDrawTime = prepareDrawTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getFirstDragonTiger() {
        return firstDragonTiger;
    }

    public void setFirstDragonTiger(Integer firstDragonTiger) {
        this.firstDragonTiger = firstDragonTiger;
    }

    public Integer getLastBigSmall() {
        return lastBigSmall;
    }

    public void setLastBigSmall(Integer lastBigSmall) {
        this.lastBigSmall = lastBigSmall;
    }

    public Integer getSumBigSmall() {
        return sumBigSmall;
    }

    public void setSumBigSmall(Integer sumBigSmall) {
        this.sumBigSmall = sumBigSmall;
    }

    public Integer getSumNum() {
        return sumNum;
    }

    public void setSumNum(Integer sumNum) {
        this.sumNum = sumNum;
    }

    public Integer getSumSingleDouble() {
        return sumSingleDouble;
    }

    public void setSumSingleDouble(Integer sumSingleDouble) {
        this.sumSingleDouble = sumSingleDouble;
    }

    public Integer getIgnoreAnalysisFlag() {
        return ignoreAnalysisFlag;
    }

    public void setIgnoreAnalysisFlag(Integer ignoreAnalysisFlag) {
        this.ignoreAnalysisFlag = ignoreAnalysisFlag;
    }
}