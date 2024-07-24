package org.springjpa.springjpa.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
@Table(name = "cities")
public class City {


    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @JsonIgnore will omit the field from the data returned
    private Long id;

    @Column(name = "city_name")
    private String cityName;

//TODO   @Column(name = "city_code", columnDefinition = "character varying(3) not null default 'NA'") Causing error that did not break code debug later
    @Column(name = "city_code")
    private String cityCode;

    //    @Transient // will ignore this field when updating table columns
//    private String beanI
//    d;

    @Column(name = "country_id")
    private int countryId;
    @ManyToOne
    @JoinColumn(name="country_id", insertable = false, updatable = false)
    private Country country;
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public Long getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public Country getCountry() {
        return country;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
