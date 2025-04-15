package efub.assignment.community.post.dto.request;

import jakarta.validation.constraints.Size;

// Record: 불변한 객체를 정의하는 데이터 클래스
// 모든 필드 final 자동 선언
public record PostUpdateRequest(
        @Size(min = 5, max = 500, message = "내용은 5자 이상 500자 이하로 입력해야 합니다.")
        String content) {
}