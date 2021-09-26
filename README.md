
* TDD -> TFD + Refactoring

1. todo list 작성(도메인 개념 습득)
   - 컴퓨터 수와 1자리와 입력한 수 1자리와 비교 - Ball
   - 컴퓨터 수 3자리와 입력한 수 1자리씩 비교 - Balls
   - 컴퓨터 수 3자리와 입력한 수 3자리씩 비교 - Balls
   - strike / ball 확인 - PlayResult  
   - 1부터 9까지 서로 다른 임의수 3개 생성 - NumberGenerator
2. tdd 로 구현하기 쉬운 코드부터 작성(예 : 유틸, input/output 정확한 것)
3. 큰 단위 -> 작은 단위로 쪼개기
4. 객체의 인스턴스 변수에 접근 x -> 메시지를 보내라
5. 객체끼리 비교(equals,hashcode)
6. 원시값을 객체로 포장해라
    - 유효청 체크 가능
    - 로직을 담을 수 있다
    