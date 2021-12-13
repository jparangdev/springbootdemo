package kr.co.jparangdev.springbootdemo.biz.test.domain;

import java.time.LocalDateTime;

/*
* seq           bigint NOT NULL AUTO_INCREMENT, --주문 PK
  user_seq      bigint NOT NULL,                --주문자 PK (users 테이블 참조)
  product_seq   bigint NOT NULL,                --주문상품 PK (products 테이블 참조)
  review_seq    bigint DEFAULT NULL,            --주문에 대한 리뷰 PK (reviews 테이블 참조)
  state         enum('REQUESTED','ACCEPTED','SHIPPING','COMPLETED','REJECTED') DEFAULT 'REQUESTED' NOT NULL,
                                                --주문상태
  request_msg   varchar(1000) DEFAULT NULL,     --주문 요청 메시지
  reject_msg    varchar(1000) DEFAULT NULL,     --주문 거절 메시지
  completed_at  datetime DEFAULT NULL,          --주문 완료 처리 일자
  rejected_at   datetime DEFAULT NULL,          -- 주문 거절일자
  create_at     datetime NOT NULL DEFAULT CURRENT_TIMESTAMP(),
*
*
* */
public class Order {

	private Long seq;
	private Long userSeq;
	private Long productSeq;
	private Long reviewSeq;
	private OrderState state;
	private String requestMsg;
	private String rejectMsg;
	private LocalDateTime completedAt;
	private LocalDateTime rejectedAt;
	private LocalDateTime createAt;

	public Order(Long seq, Long userSeq, Long productSeq, Long reviewSeq, OrderState state, String requestMsg,
		String rejectMsg, LocalDateTime completedAt, LocalDateTime rejectedAt, LocalDateTime createAt) {
		this.seq = seq;
		this.userSeq = userSeq;
		this.productSeq = productSeq;
		this.reviewSeq = reviewSeq;
		this.state = state;
		this.requestMsg = requestMsg;
		this.rejectMsg = rejectMsg;
		this.completedAt = completedAt;
		this.rejectedAt = rejectedAt;
		this.createAt = createAt;
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

	public Long getReviewSeq() {
		return reviewSeq;
	}

	public void setReviewSeq(Long reviewSeq) {
		this.reviewSeq = reviewSeq;
	}

	public OrderState getState() {
		return state;
	}

	public void setState(OrderState state) {
		this.state = state;
	}

	public String getRequestMsg() {
		return requestMsg;
	}

	public void setRequestMsg(String requestMsg) {
		this.requestMsg = requestMsg;
	}

	public String getRejectMsg() {
		return rejectMsg;
	}

	public void setRejectMsg(String rejectMsg) {
		this.rejectMsg = rejectMsg;
	}

	public LocalDateTime getCompletedAt() {
		return completedAt;
	}

	public void setCompletedAt(LocalDateTime completedAt) {
		this.completedAt = completedAt;
	}

	public LocalDateTime getRejectedAt() {
		return rejectedAt;
	}

	public void setRejectedAt(LocalDateTime rejectedAt) {
		this.rejectedAt = rejectedAt;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public static final class OrderBuilder {
		private Long seq;
		private Long userSeq;
		private Long productSeq;
		private Long reviewSeq;
		private OrderState state;
		private String requestMsg;
		private String rejectMsg;
		private LocalDateTime completedAt;
		private LocalDateTime rejectedAt;
		private LocalDateTime createAt;

		private OrderBuilder() {
		}

		public static OrderBuilder anOrder() {
			return new OrderBuilder();
		}

		public OrderBuilder seq(Long seq) {
			this.seq = seq;
			return this;
		}

		public OrderBuilder userSeq(Long userSeq) {
			this.userSeq = userSeq;
			return this;
		}

		public OrderBuilder productSeq(Long productSeq) {
			this.productSeq = productSeq;
			return this;
		}

		public OrderBuilder reviewSeq(Long reviewSeq) {
			this.reviewSeq = reviewSeq;
			return this;
		}

		public OrderBuilder state(OrderState state) {
			this.state = state;
			return this;
		}

		public OrderBuilder requestMsg(String requestMsg) {
			this.requestMsg = requestMsg;
			return this;
		}

		public OrderBuilder rejectMsg(String rejectMsg) {
			this.rejectMsg = rejectMsg;
			return this;
		}

		public OrderBuilder completedAt(LocalDateTime completedAt) {
			this.completedAt = completedAt;
			return this;
		}

		public OrderBuilder rejectedAt(LocalDateTime rejectedAt) {
			this.rejectedAt = rejectedAt;
			return this;
		}

		public OrderBuilder createAt(LocalDateTime createAt) {
			this.createAt = createAt;
			return this;
		}

		public Order build() {
			return new Order(seq, userSeq, productSeq, reviewSeq, state, requestMsg, rejectMsg, completedAt, rejectedAt,
				createAt);
		}
	}
}
