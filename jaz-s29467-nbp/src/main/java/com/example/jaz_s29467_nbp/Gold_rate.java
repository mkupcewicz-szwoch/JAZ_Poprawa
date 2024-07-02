package com.example.jaz_s29467_nbp;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;

@Entity
public class Gold_rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Id of gold rate.", required = true)
    private Integer id;

    @Schema(description = "Symbol of currency", required = true)
    @Column(name = "gold", columnDefinition = "VARCHAR(255)")
    @Enumerated(EnumType.STRING)
    private gold gold;

    @Schema(description = "Start date used to calculate rate", required = true)
    @Column(name = "start_date")
    private LocalDate start_date;

    @Schema(description = "End date used to calculate rate", required = true)
    @Column(name = "end_date")
    private LocalDate end_date;

    @Schema(description = "Average total value of rates", required = true)
    @Column(name = "avg_total")
    private Double avg_total;

    @Schema(description = "Date and time of request", required = true)
    @Column(name = "created")
    private Instant created;

    public Gold_rate(Integer id, gold gold, LocalDate start_date, LocalDate end_date, Double avg_total, Instant created) {
        this.id = id;
        this.gold = gold;
        this.start_date = start_date;
        this.end_date = end_date;
        this.avg_total = avg_total;
        this.created = created;
    }

    public Gold_rate() {

    }

    public Integer getId() {return id;}
    public void setId(Integer id) {
        this.id = id;
    }


    public gold getgold() {
        return gold;
    }
    public void setgold(gold gold) {this.gold = gold;}


    public LocalDate getStart_date() {
        return start_date;
    }
    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }


    public LocalDate getEnd_date() {
        return end_date;
    }
    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }



    public Double getAvg_total() {
        return avg_total;
    }
    public void setAvg_total(Double avg_total) {
        this.avg_total = this.avg_total;
    }



    public Instant getCreated() {
        return created;
    }
    public void setCreated(Instant created) {
        this.created = created;
    }


}
