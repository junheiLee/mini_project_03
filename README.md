# 레거시 프로젝트
&nbsp; [첫 번째 고도화 repository](https://github.com/junheiLee/mini_project_03_team8) (Model1 방식 -> Model2 방식)<br>
&nbsp; [두 번째 고도화 repository](https://github.com/junheiLee/mini_project_03_team8_spring) (Spring framework, MyBatis 도입)

## 기능 목록

### MainController
- index: 메인 페이지로 이동(완료)

### MemberController
- join_form: 회원 가입 페이지로 이동 (완료)
- id_check_form: 아이디 중복 체크 페이지로 이동 (완료)
- contract: 약관 동의 페이지로 이동 (완료)
- join: 회원 가입 정보를 처리 (완료)
- login_form: 로그인 페이지로 이동 (완료)
- login: 로그인 정보를 처리 (완료)
- logout: 로그아웃을 처리 (완료)

### ItemController
- product_detail: 상품 상세 페이지로 이동 (완료)
- category: 상품 카테고리 정보를 처리 (완료) - 미 사용 상품 표시 제외

### CartController
- cart_insert: 장바구니에 상품을 추가 (완료)
- cart_list: 장바구니 목록을 조회 (완료) - 체크 상품만 삭제 혹은 주문하도록 변경
- cart_delete: 장바구니에서 상품을 삭제 (완료)

### OrderController
- order_insert: 주문을 등록 (완료) - 즉시 구매 기능 오류 해결, 장바구니에서 구매 오류 해결
- order_detail: 주문 상세 정보를 조회 (완료)
- order_all: 모든 주문 정보를 조회 (완료)
- mypage: 진행중인 주문 목록 (완료)

### QnaController
- qna_list: Q&A 목록을 조회 (완료)
- qna_write_form: Q&A 작성 페이지로 이동 (완료)
- qna_write: Q&A 작성 정보를 처리 (완료)
- qna_view: Q&A 상세 정보를 조회 (완료)

### AdminController
- admin_login_form: 관리자 로그인 페이지로 이동 (완료)
- admin_login: 관리자 로그인 정보를 처리 (완료)
- admin_member_list: 회원 목록을 조회 (완료)
- admin_logout: 관리자 로그아웃을 처리 (완료)
- admin_product_list: 상품 목록을 조회 (완료) - 미 사용 상품 표시 추가
- admin_product_write_form: 상품 등록 페이지로 이동 (완료)
- admin_product_write: 상품 정보를 등록 (완료)
- admin_product_detail: 상품 상세 정보를 조회 (완료)
- admin_product_update_form: 상품 정보 수정 페이지로 이동 (완료)
- admin_product_update: 상품 정보를 수정 (완료) - 미 사용 시, useyn table에 "n" 기입
- admin_order_list: 주문 목록을 조회 (완료)
- admin_order_save: 주문 정보를 저장 (완료)
- admin_qna_list: Q&A 목록을 조회  (완료)
- admin_qna_detail: Q&A 상세 정보를 조회  (완료)
- admin_qna_resave: Q&A 답변 정보를 저장 (완료)
