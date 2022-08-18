package com.bitcamp221.didabara.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "username", nullable = false, unique = true)
  private String  username;

  @Column(name = "password", nullable = false, length = 256)
  private String password;

  @Column(name = "nickname", nullable = false, length = 30, unique = true)
  private String nickname;

  @OneToOne(mappedBy = "user")
  private UserInfoEntity userInfoEntity;

  @OneToOne(mappedBy = "user")
  private EmailConfigEntity emailConfigEntity;

  @OneToMany(mappedBy = "user")
  private List<SubscriberEntity> subscriberEntities = new ArrayList<SubscriberEntity>();

  @OneToMany(mappedBy = "host")
  private List<ReportEntity> reportEntities = new ArrayList<ReportEntity>();

  @OneToMany(mappedBy = "user")
  private List<ReportEntity> reportEntities2 = new ArrayList<ReportEntity>();

  @OneToMany(mappedBy = "host")
  private List<CategoryEntity> categoryEntities = new ArrayList<CategoryEntity>();

}