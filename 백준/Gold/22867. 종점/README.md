# [Gold V] 종점 - 22867 

[문제 링크](https://www.acmicpc.net/problem/22867) 

### 성능 요약

메모리: 55292 KB, 시간: 804 ms

### 분류

자료 구조, 문자열, 정렬, 스위핑, 파싱, 우선순위 큐

### 제출 일자

2025년 9월 2일 15:51:32

### 문제 설명

<p>주행을 마친 버스들이 종점에 들어온다. 종점에 들어온 버스는 버스를 정비하기 위한 자리에 들어간다. 즉, 종점에 버스 4대가 있다면 버스를 정비할 수 있는 공간이 최소 4개 이상 필요하다. 만약 같은 시각에 종점에 들어오는 버스 A와 종점에서 출발하는 버스 B가 있을 경우는 버스 B가 먼저 종점에서 출발하고 그 다음으로 버스 A가 종점으로 들어온다.</p>

<p>버스의 시간표가 매일 동일하며 종점에 들어오는 시각과 나가는 시각이 매일 동일하다.</p>

<p>이번에 버스 시간표가 변경이 되어 버스를 정비하는 공간이 최소 몇 개 이상 필요한지 다시 계산을 해야한다. 이를 도와 계산을 해주자.</p>

### 입력 

 <p>첫 번째 줄에는 종점에 들어오는 버스들의 개수 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>이 주어진다.</p>

<p>두 번째 줄부터 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c2B"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="3"><mjx-c class="mjx-c31"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi><mo>+</mo><mn>1</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N+1$</span></mjx-container>번째 줄까지 각 버스가 종점에 들어오는 시각과 종점에서 나가는 시각이 주어진다. 한 버스의 나가는 시각은 들어오는 시각보다 늦다.</p>

<p>주어지는 시각의 형식은 다음과 같다. <code>HH:MM:SS.sss</code> (<code>HH</code>는 시각을, <code>MM</code>은 분, <code>SS</code>은 초, <code>sss</code> 밀리초를 의미한다.)</p>

### 출력 

 <p>버스 정비를 위한 공간이 최소 몇 개 이상 필요한지 출력한다.</p>

