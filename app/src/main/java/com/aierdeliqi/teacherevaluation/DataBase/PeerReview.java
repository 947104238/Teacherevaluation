package com.aierdeliqi.teacherevaluation.DataBase;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/*
* 同行评价*/
@Entity(tableName = "PeerReview",primaryKeys = {"tg_id","ted_id","ting_id"},foreignKeys = {
        @ForeignKey(entity = TeachingGroup.class,parentColumns = "id",childColumns = "tg_id"),
        @ForeignKey(entity = Teacher.class,parentColumns = {"id"},childColumns = {"ted_id",}),
        @ForeignKey(entity = Teacher.class,parentColumns = "id",childColumns = "ting_id")},
        indices = {@Index(value = "tg_id",unique = true),@Index(value = "ted_id",unique = true),
        @Index(value = "ting_id",unique = true)})
public class PeerReview {
    /*
    * 授课组号*/
    private long tg_id;
    /*
    * 被评人职工号*/
    private long ted_id;
    /*
    * 评价人职工号*/
    private long ting_id;
    /*
    * 评价指标*/
    @Embedded
    private Evaluation evaluation;

    public PeerReview() {
    }
    @Ignore
    public PeerReview(long tg_id, long ted_id, long ting_id, Evaluation evaluation) {
        this.tg_id = tg_id;
        this.ted_id = ted_id;
        this.ting_id = ting_id;
        this.evaluation = evaluation;
    }

    public long getTg_id() {
        return tg_id;
    }

    public void setTg_id(long tg_id) {
        this.tg_id = tg_id;
    }

    public long getTed_id() {
        return ted_id;
    }

    public void setTed_id(long ted_id) {
        this.ted_id = ted_id;
    }

    public long getTing_id() {
        return ting_id;
    }

    public void setTing_id(long ting_id) {
        this.ting_id = ting_id;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }
}
