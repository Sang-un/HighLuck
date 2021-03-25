package com.HighLuck.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

// 모든 entity 의 상위 클래스가 되어 entity 들의 시간을 자동으로 관리함
@Getter
@MappedSuperclass // entity 들이 이 클래스를 상속할 경우 필드들도 칼럼을 인식하게 해줌
@EntityListeners(AuditingEntityListener.class) // auditing 기능을 포함시킴
public abstract class BaseTimeEntity {

    @CreatedDate // 생성되어 저장될때 시간이 자동 저장되게 해줌
    private LocalDateTime createdDate;

    @LastModifiedDate // 죄회한 시간을 자동 저장 해줌
    private LocalDateTime modifiedDate;
}
