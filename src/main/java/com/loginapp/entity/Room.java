//package com.loginapp.entity;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "rooms")
//public class Room {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String title;
//    private String city;
//    private Double price;
//    private String roomType;
//    private String imageName;
//
//    @ManyToOne
//    @JoinColumn(name = "owner_id")
//    private User owner;
//
//    // Getters & Setters
//    public Long getId() { return id; }
//    public void setId(Long id) { this.id = id; }
//
//    public String getTitle() { return title; }
//    public void setTitle(String title) { this.title = title; }
//
//    public String getCity() { return city; }
//    public void setCity(String city) { this.city = city; }
//
//    public Double getPrice() { return price; }
//    public void setPrice(Double price) { this.price = price; }
//
//    public String getRoomType() { return roomType; }
//    public void setRoomType(String roomType) { this.roomType = roomType; }
//
//    public String getImageName() { return imageName; }
//    public void setImageName(String imageName) { this.imageName = imageName; }
//
//    public User getOwner() { return owner; }
//    public void setOwner(User owner) { this.owner = owner; }
//}
