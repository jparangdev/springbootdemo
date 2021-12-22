package kr.co.jparangdev.springbootdemo.biz.test.domain;

import java.time.LocalDateTime;

public class Review {


	private Long seq;

	private Long userSeq;

	private Long productSeq;

	private String content;

	private LocalDateTime createdAt;

	public Review(Long seq, Long userSeq, Long productSeq, String content, LocalDateTime createdAt) {
		this.seq = seq;
		this.userSeq = userSeq;
		this.productSeq = productSeq;
		this.content = content;
		this.createdAt = createdAt;
	}

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public Long getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(Long userSeq) {
		this.userSeq = userSeq;
	}

	public Long getProductSeq() {
		return productSeq;
	}

	public void setProductSeq(Long productSeq) {
		this.productSeq = productSeq;
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

	public static final class Builder {
		private Long seq;
		private Long userSeq;
		private Long productSeq;
		private String content;
		private LocalDateTime createdAt;

		private Builder() {
		}

		public static Builder aReview() {
			return new Builder();
		}

		public Builder seq(Long seq) {
			this.seq = seq;
			return this;
		}

		public Builder userSeq(Long userSeq) {
			this.userSeq = userSeq;
			return this;
		}

		public Builder productSeq(Long productSeq) {
			this.productSeq = productSeq;
			return this;
		}

		public Builder content(String content) {
			this.content = content;
			return this;
		}

		public Builder createdAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
			return this;
		}

		public Review build() {
			return new Review(seq, userSeq, productSeq, content, createdAt);
		}
	}
}
