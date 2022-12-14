package com.bitcamp221.didabara.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
public class CategoryEntity extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", unique = true, nullable = false)
  private Long id;

  @Column(name = "host_id", nullable = false)
  private Long host;

  @Column(name = "title", nullable = false)
  private String title;

  @Column(name = "content", nullable = false)
  private String content;

  @Column(name = "invite_code", nullable = false)
  private String inviteCode;

  @Column(name = "profile_image_url", nullable = false)
//  @ColumnDefault("카테고리 기본 이미지")
  private String profileImageUrl;

  public void changeEntity (CategoryEntity categoryEntity){
    this.id = categoryEntity.getId();
    this.host = categoryEntity.getHost();
    this.content = categoryEntity.getContent();
    this.title = categoryEntity.getTitle();
    this.inviteCode = categoryEntity.getInviteCode();
    this.profileImageUrl = categoryEntity.getProfileImageUrl();
  }
}
