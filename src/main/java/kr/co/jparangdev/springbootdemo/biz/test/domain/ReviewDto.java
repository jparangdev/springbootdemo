package kr.co.jparangdev.springbootdemo.biz.test.domain;

import java.time.LocalDateTime;

public class ReviewDto {

	private Long seq;
	private Long productId;
	private String content;
	private LocalDateTime createdAt;

	public static ReviewDto from(Review review) {
		return new ReviewDto(review.getSeq(), review.getProductSeq(), review.getContent(), review.getCreatedAt());
	}

	public ReviewDto(Long seq, Long productId, String content, LocalDateTime createdAt) {
		this.seq = seq;
		this.productId = productId;
		this.content = content;
		this.createdAt = createdAt;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


}
