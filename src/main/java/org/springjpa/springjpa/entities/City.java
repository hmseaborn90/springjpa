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

    @Column(name = "city_code", columnDefinition = "varchar(3) NOT NULL DEFAULT 'NA'")
    private String cityCode;

    @Transient // will ignore this field when updating table columns
    private String beanId;

    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;

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
