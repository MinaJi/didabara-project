package com.bitcamp221.didabara.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_info")
public class UserInfoEntity extends BaseTimeEntity {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

//  외래키를 가져와서 기본키로 설정하기 위한 설정.
  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @MapsId
  @JoinColumn(name = "id")
  private UserEntity user;

  @Column(name = "job", nullable = false)
  private String job;

  //  0은 일반 유저, 1은 관리자
  @Column(name = "role", nullable = false)
  @ColumnDefault("0")
  private int role;

  @Column(name = "ban", nullable = false)
  @ColumnDefault("false")
  private boolean ban;

  //  프로필 사진 컬럼
  @Column(name = "profile_image_url", nullable = false)
  //  @ColumnDefault("기본 프로필 제공 이미지 경로")
  private String profileImageUrl;
}