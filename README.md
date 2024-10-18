# GA X GA - 국내 여행지 추천 웹 페이지

### 개요
***
- Spring Boot를 이용한 여행지 추천 페이지 관리 웹 프로젝트
- 이 웹페이지는 메인/ 여행지추천(가보자고) / 여행지 후기 공유(가봤다고) / 이벤트 / 마이페이지
  로 구분

***
##### 웹 페이지의 목적 및 주요 기능 (요약)
- 국내 숨겨진 명소들을 웹 페이지 방문자에게 지역별/테마별로 분류하여 소개
- 소개 외에도 사용자들끼리 여행지 후기를 공유할 수 있도록 별도의 후기 컨셉 페이지 제작
- Spring Security를 통한 로그인 기능 구현 (비밀번호 찾기 - 임시 비밀번호 이메일 전송)
- 각 여행지 상세 페이지 / 후기 상세 페이지 에서 여행지 저장 및 좋아요 구현
- 후기 작성 페이지에서는 파일 업로드, 상세 페이지에서는 댓글 기능 구현
- 저장한 여행지 및 좋아요 누른 게시글은 마이페이지에서 확인 가능, 별도로 수정 및 삭제 가능
- 이벤트 페이지에서는 Scheduler를 활용해 일정 시간이 지나면 이벤트가 종료될 수 있도록 하여, 종료됨과 동시에 당첨자를 좋아요 순, 게시글 작성 순 등으로 자동으로 추출한다.

*** 
##### 일정
- 2024-04-28 ~2024-05-31

***
### 사용 기술 및 개발 환경
- DB : Oracle 11g
- Framework/Flatform : Spring Boot , Spring Security
- Language : JAVA , Javascript, HTML5, CSS3
- Tool : IntelliJ,GitHub, Oracle SQL Developeer, PostMan
***
### Entity Relationship Diagram
![GA X GA DB](https://github.com/user-attachments/assets/c1d6c030-47cc-468b-97a7-bbb8856d7eff)
- GR : 지역 카테고리 테이블
- GT : 테마 카테고리 테이블
- GP : 여행지 정보 테이블
- jjim : 여행지 저장(장바구니) 테이블
- heart(like) : 좋아요 (후기 게시글) 테이블
- Gabowatdago : 후기 작성 게시판 테이블
- BaseEntity : 게시글 및 댓글 등록시간 extends용 테이블
- Event : 이벤트 페이지 테이블(진행중 / 종료된)

***
### 내용
- ### 로그인
- ![image](https://github.com/user-attachments/assets/ed479514-3430-40c6-aa04-1af3d5600df6)

##### WebSecurityConfig
```
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class WebSecurityConfig {

    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/css/**", "/js/**", "/img/**", "/fonts/**","terms.html", "privacy.html", "copyright.html",
                                "/login/**","/api/**", "/findInfo/**","/joinMembership/**","/main", "/gabojago", "/gabojagoing", "/", "/event"
                        ).permitAll()
                        .anyRequest().authenticated());
        http
                .formLogin((auth) -> auth.loginPage("/login")
                        .loginProcessingUrl("/login")
                        .usernameParameter("gaId")
                        .passwordParameter("gaPass")
                        .defaultSuccessUrl("/main", true)
                        .failureUrl("/login?error=true")
                        .failureHandler(authenticationFailureHandler())
                        .successHandler(customAuthenticationSuccessHandler)
                );
        http
                .logout((logout) -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                        .logoutSuccessUrl("/main")
                        .invalidateHttpSession(true));
        http
                .csrf((auth) -> auth.disable());

        return http.build();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new CustomAuthenticationFailureHandler();
    }
}
```
##### FindInfoContorller
```
@Controller
@Slf4j
public class FindInfoController {

    @Autowired
    private FindInfoService findInfoService;

    @Autowired
    private MailService mailService;

    @GetMapping("/findInfo")
    public String showFindInfo() {
        return "public/accountManagement/findInfo";
    }

    @PostMapping("/findInfo/ID")
    public String findId(User user, RedirectAttributes redirectAttributes){
        User data = findInfoService.findUserInfoId(user);
        if(data == null){
            redirectAttributes.addFlashAttribute("msg", "회원정보가 없습니다.");
            return "redirect:/findInfo";
        } else{
            redirectAttributes.addFlashAttribute("msg", "회원님의 ID는 : " + data.getGaId());
            return "redirect:/findInfo";
        }
    }
    @PostMapping("/findInfo/Pass")
    public String findPass(User user, RedirectAttributes redirectAttributes){
        User data = findInfoService.findUserInfoPass(user);
        if(data == null){
            redirectAttributes.addFlashAttribute("msg", "입력하신 정보가 틀립니다.");
            return "redirect:/findInfo";
        } else{
            mailService.sendSimpleMail("[GA X GA] 임시 비밀번호 발송", "taein4546@gmail.com", "임시 비밀번호입니다. 마이페이지에서 비밀번호 변경해주세요", data);
            redirectAttributes.addFlashAttribute("msg", "회원가입에 입력하신 이메일로 임시 비밀번호 보내드렸습니다.");
            return "redirect:/login";
        }
    }
}
```
##### Handler
```
@Component
@Slf4j
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String saveUserId = request.getParameter("saveUserId");
        String gaId = request.getParameter("gaId");

        if ("on".equals(saveUserId)) {
            Cookie cookie = new Cookie("saveUserId", gaId);
            cookie.setMaxAge(7 * 24 * 60 * 60); // 7 days
            cookie.setPath("/");
            response.addCookie(cookie);
        } else {
            Cookie cookie = new Cookie("saveUserId", null);
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
        }

        response.sendRedirect("/main");
    }
}
```

```
@Slf4j
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());

        String errorMsg;

        if (e instanceof BadCredentialsException || e instanceof InternalAuthenticationServiceException){
            errorMsg="아이디 또는 비밀번호가 맞지 않습니다.";
        }else if (e instanceof UsernameNotFoundException){
            errorMsg="존재하지 않는 아이디 입니다.";
        }
        else{
            errorMsg="알 수 없는 이유로 로그인이 안되고 있습니다.";
        }

        String encodedErrorMsg = URLEncoder.encode(errorMsg,"UTF-8");

        setDefaultFailureUrl("/login/Result?error=true&exception=" + encodedErrorMsg);
        log.info("customMsg = " + encodedErrorMsg);
        super.onAuthenticationFailure(httpServletRequest, httpServletResponse, e);
    }
}
```
***  

- ### 댓글
- ![image](https://github.com/user-attachments/assets/89e61f1e-bb8d-478e-8e25-5994c224b95e)

##### DTO
  ```
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CmtDto {
    private Long id;
    private Long gabowatdagoId;
    private String nickname;
    private String body;

    public static CmtDto createCommentDto(Cmt cmt) {
        return new CmtDto(
                cmt.getId(),
                cmt.getGabowatdago().getId(),
                cmt.getNickname(),
                cmt.getBody()
        );
    }
}
  ```
##### Controller
  ```
@RestController
public class CmtApiController {
    @Autowired
    private CmtService cmtService;
    //1. 댓글 조회
    @GetMapping("/api/gabowatdago/{gabowatdagoId}/cmts")
    public ResponseEntity<List<CmtDto>> cmts(@PathVariable("gabowatdagoId") Long gabowatdagoId){
        List<CmtDto> dtos = cmtService.comments(gabowatdagoId);
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }
    //2. 댓글 생성
    @PostMapping("/api/gabowatdago/{gabowatdagoId}/cmts")
    public ResponseEntity<CmtDto> createCmt(@PathVariable("gabowatdagoId")Long gabowatdagoId,
                                            @RequestBody CmtDto cmtDto){
        CmtDto createdDto = cmtService.create(gabowatdagoId, cmtDto);
        return ResponseEntity.status(HttpStatus.OK).body(createdDto);
    }
    //3. 댓글 수정
    @PatchMapping("/api/cmts/{id}")
    public ResponseEntity<CmtDto> updateCmt(@PathVariable("id") Long id, @RequestBody CmtDto cmtDto){
        CmtDto updatedDto = cmtService.update(id, cmtDto);
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);
    }


    //4. 댓글 삭제
    @DeleteMapping("/api/cmts/{id}")
    public ResponseEntity<CmtDto> deleteCmt(@PathVariable("id") Long id){
        CmtDto deletedDto = cmtService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(deletedDto);
    }



}
 ```
##### Service
 ```
@Service
public class CmtService {
    @Autowired
    private CmtRepository cmtRepository;
    @Autowired
    private GabowatdagoRepository GabowatdagoRepository;

    public List<CmtDto> comments(Long gabowatdagoId) {
        //댓글 조회
        List<Cmt> cmts = cmtRepository.findByGabowatdagoId(gabowatdagoId);
        List<CmtDto> dtos = new ArrayList<CmtDto>();
        for(int i=0; i<cmts.size(); i++){
            Cmt cmt = cmts.get(i);
            CmtDto dto = CmtDto.createCommentDto(cmt);
            dtos.add(dto);
        }
        //결과 반환
        return dtos;
    }

    @Transactional
    public CmtDto create(Long gabowatdagoId, CmtDto cmtDto) {
        //게시글 조회 및 예외 발생
        Gabowatdago gabowatdago = GabowatdagoRepository.findById(gabowatdagoId)
                .orElseThrow(() -> new IllegalArgumentException("댓글 생성 실패"+ "대상 게시글이 없습니다."));
        // 댓글 엔티티 생성
        Cmt cmt = Cmt.createComment(cmtDto, gabowatdago);
        // 댓글 엔티티를 db에 저장
        Cmt created = cmtRepository.save(cmt);
        // DTO로 변환해 반환
        return CmtDto.createCommentDto(created);

    }
    @Transactional
    public CmtDto update(Long id, CmtDto cmtDto) {
        //댓글 조회 및 예외 발생
        Cmt target = cmtRepository.findById(id) // 수정할 댓글 가져오기
                .orElseThrow(()->new IllegalArgumentException("댓글 수정 실패, 해당 댓글이 없습니다."));
        // 댓글 수정
        target.patch(cmtDto);
        // db로 갱신
        Cmt updated = cmtRepository.save(target);
        // 댓글 엔티티를 dto로 변환해 반환
        return CmtDto.createCommentDto(updated);
    }

    public CmtDto delete(Long id) {
        //댓글 조회 및 예외 발생
        Cmt target = cmtRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("댓글 삭제 실패, 해당 댓글이 없습니다."));
        //댓글 삭제
        cmtRepository.delete(target);
        //삭제 댓글을 dto로 변환 및 반환
        return CmtDto.createCommentDto(target);
    }
}

  ```
***
- ### 좋아요
- ![image](https://github.com/user-attachments/assets/8e5fbb22-1062-44fe-9c6d-16d273fcb074)

##### DTO
```
@Getter
@NoArgsConstructor
@Setter
public class LikeDto {
    private Long userId;
    private Long gabowatdagoId;

    public LikeDto(Long userId, Long gabowatdagoId) {
        this.userId = userId;
        this.gabowatdagoId = gabowatdagoId;
    }
}
```
##### Controller
```
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/gabowatdago/like")
public class LikeController {
    private final LikeService likeService;

    @PostMapping
    public ResponseEntity<?> insertLike(@RequestBody @Validated LikeDto likeDto) throws Exception {
        likeService.insert(likeDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteLike(@RequestBody @Validated LikeDto likeDto) throws Exception {
        likeService.delete(likeDto);
        return ResponseEntity.ok().build();
    }
}
```
##### Service
```
@Slf4j
@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;
    private final GabowatdagoRepository gabowatdagoRepository;
    private final UserRepository userRepository;

    //전달받은 userId와 gabowatdagoId를 통해 member와 board를 조회하고 저장 혹은 삭제를 진행
    //좋아요 추가 메서드
    @Transactional
    public void insert(LikeDto likeDto) throws Exception {
        Gabowatdago gabowatdago = gabowatdagoRepository.findById(likeDto.getGabowatdagoId())
                .orElseThrow(() -> new Exception("Gabowatdago not found: " + likeDto.getGabowatdagoId()));
        User user = userRepository.findById(likeDto.getUserId())
                .orElseThrow(() -> new Exception("User not found:" + likeDto.getUserId()));
        //이미 좋아요 있으면 에러 반환
        if(likeRepository.findByGabowatdagoAndUser(gabowatdago, user).isPresent()){
            throw new DuplicateRequestException("already exist data my user id : " + user.getGaId()
            + " ," + "gabowatdago id : " + gabowatdago.getId());
        }
        Like like = Like.builder()
                .gabowatdago(gabowatdago)
                .user(user)
                .build();

        gabowatdago.likeCountAdd();
        gabowatdagoRepository.save(gabowatdago);
        likeRepository.save(like);

    }

    @Transactional
    public void delete(LikeDto likeDto) throws Exception {
        User user = userRepository.findById(likeDto.getUserId())
                .orElseThrow(() -> new Exception("Could not found User id : " + likeDto.getUserId()));

        Gabowatdago gabowatdago = gabowatdagoRepository.findById(likeDto.getGabowatdagoId())
                .orElseThrow(() -> new Exception("Could not found Gabowtdago id : " + likeDto.getGabowatdagoId()));

        Like like = likeRepository.findByGabowatdagoAndUser(gabowatdago, user)
                        .orElseThrow(() -> new Exception("Could not found like id"));

        gabowatdago.likeCountDelete();
        gabowatdagoRepository.save(gabowatdago);
        likeRepository.delete(like);

    }
}

```
***
- ### 여행지 저장(장바구니)
- ![image](https://github.com/user-attachments/assets/181c745d-fcc3-42b5-b8bc-1fda9279882b)

##### Service
```
@Service
@RequiredArgsConstructor
public class JjimService {
    private final JjimRepository jjimRepository;
    private final GpRepository gpRepository;
    private final UserRepository userRepository;

    @Transactional
    public void insert(JjimDto jjimDto) throws Exception {
        GP gp = gpRepository.findById(jjimDto.getGabojagoId())
                .orElseThrow(() -> new Exception("not found: " + jjimDto.getGabojagoId()));
        User user = userRepository.findById(jjimDto.getUserId())
                .orElseThrow(() -> new Exception("User not found: " + jjimDto.getUserId()));

        if(jjimRepository.findByGpidAndUser(gp, user).isPresent()){
            throw new DuplicateRequestException("already exist data my user id :" + user.getGaId()
                    + " ," + "gabojago id : " + gp.getId());
        }
        Jjim jjim = Jjim.builder()
                .gp(gp)
                .user(user)
                .build();
        gp.increaseJjimCount();
        gpRepository.save(gp);
        jjimRepository.save(jjim);
    }


    @Transactional
    public void delete(JjimDto jjimDto) throws Exception {
        User user = userRepository.findById(jjimDto.getUserId())
                .orElseThrow(() -> new Exception("Could not found User id: " + jjimDto.getUserId()));

        GP gp = gpRepository.findById(jjimDto.getGabojagoId())
                .orElseThrow(() -> new Exception("Could not found GP id: " + jjimDto.getGabojagoId()));

        Jjim jjim = jjimRepository.findByGpidAndUser(gp, user)
                .orElseThrow(() -> new Exception("Could not found jjim id"));
        gp.decreseJjimCount();
        gpRepository.save(gp);
        jjimRepository.delete(jjim);
    }
}
```
***
- ### 파일업로드
- ![image](https://github.com/user-attachments/assets/0da98f57-b6cb-443a-8cc6-5289425ccdd0)

```
@Transactional
    public String create(GabowatdagoForm form, Long userCode) throws IOException {
        //1. DTO를 엔티티로
        Gabowatdago gabowatdago = form.toEntity();
        //로그인한 사람의 userCode를 게시글 작성자 userCode로 변환해 저장
        User user = new User();
        user.setUserCode(userCode);
        gabowatdago.setUserCode(user);
        //2. 레퍼지토리로 엔티티를 DB에 저장
        Gabowatdago saved = gabowatdagoRepository.save(gabowatdago);


        Path directoryPath = Paths.get(fileDir);
        boolean directoryExists = Files.exists(directoryPath) && Files.isDirectory(directoryPath);
        if(!directoryExists){
            Files.createDirectories(directoryPath);
        }

        List<String> fileNames = new ArrayList<>();
        // 각 파일 처리
        for (MultipartFile file : form.getImage()) {
            if (!file.isEmpty()) {
                String uniqueFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                Path filePath = directoryPath.resolve(uniqueFileName);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                fileNames.add(uniqueFileName);
            }
        }

        // 모든 파일 이름을 쉼표로 구분하여 하나의 문자열로 결합
        String allFileNames = String.join(",", fileNames);
        saved.setImage(allFileNames);
        gabowatdagoRepository.save(saved); // 업데이트된 엔티티 저장


        return "redirect:/gabowatdago/" + saved.getId();

    }
```
##### 이미지 업로드 -> 등록 시 바로 출력 가능한 설정(웹에서 정적 파일을 제공하기 위해 웹서버에서 파일을 읽고 브라우저로 전달)

```
/*이미지 업로드하여 게시글 생성하면 이미지 바로 출력가능한 설정
 웹에서 정적 파일을 제공하기 위해 서버가 해당 파일의 위치를 알고, 요청받은 url에 따라 적절한 파일 반환이 필요
 여기서는
  1.addResourceHandler에서 /upload/로 시작하는 모든 요청 url(이미지url)을 처리
 2. addResourceLocations를 통해 리소스 위치 지정하여 서버가 파일을 찾을 위치를 알려준다.
 3. 요청처리 -> 사용자가 웹 브라우저를 통해 특정 이미지 파일을 요청하면 웹서버는
 addResourceHandlers 에 설정한 규칙을 사용하여 upload/** 위치에서 파일을 찾는다.
 4. 파일을 반환한다 -> 웹 서버는 이 파일을 읽고 사용자의 브라우저로 전달한다.-*/
@Configuration
public class MvcConfig implements WebMvcConfigurer {
    // 개발 시점에 사용 가능한 코드.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) { //정적 파일들의 경로를 잡아주는 메서드
        registry
                .addResourceHandler("/upload/**")
               /*addResourceHandler 메서드에서 설정한 URL 패턴과 실제 이미지 URL이 일치해야한다.
                이 프로젝트에서는 @Value("C:\\Team_Project\\BE\\gaxga\\src\\main\\resources\\static\\upload")
                경로로 주고있기 때문에, handler path에 /upload/** 로 주는것이 맞다.*/
                .addResourceLocations("file:///C:/upload/");
    }
    // 배포 시점에 사용 가능한 코드.
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry
//                .addResourceHandler("/files/**")
//                .addResourceLocations("file:/opt/files/");
//
//        // 윈도우라면
//         .addResourceLocations(“file:///C:/opt/files/“);
//    }
}
```
***
- ### 이벤트 페이지 Scheduler
##### Entity
```
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_id_seq")
    @SequenceGenerator(name="event_id_seq", sequenceName = "event_id_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column
    private String name; // 이벤트의 이름

    @Column
    private String img; // 이벤트에 보여질 이미지

    //leg_Date 필드가 start_date 와 중복되어 제거함
    @Column(name = "start_date")
    private LocalDateTime startDate; // 이벤트가 시작될 날짜

    @Column(updatable = false,name = "end_date")
    private LocalDateTime endDate; // 이벤트가 종료될 날짜

    @Column
    private String status; // 이벤트 상태 (진행 중인지 종료되었는지)

}

```
##### Scheduler
```
@Component
public class EventScheduler {

    private final EventRepository eventRepository;

    public EventScheduler(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    @Scheduled(fixedRate = 18000) // 30분 마다 실행
    public void checkAndEndEvents() {
        List<Event> events = eventRepository.findAll();
        LocalDateTime now = LocalDateTime.now();
        for (Event event : events) {
            if (event.getEndDate().isBefore(now) && !"ENDED".equals(event.getStatus())) {
                endEvent(event);
            }
        }
    }
    private void endEvent(Event event) {
        // 이벤트 종료 처리 로직
        event.setStatus("ENDED");
        eventRepository.save(event);
    }
}
```

##### Service
```
@Service
public class EventService {

    private EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Autowired
    private GabowatdagoRepository gabowatdagoRepository;
    // 이벤트 저장
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    // 모든 이벤트 가져오기
    public String getAllEvents(Model model) {
        List<Event> AllEvent = eventRepository.findAll();
        List<Gabowatdago> eventLikeWinningList = gabowatdagoRepository.findTop3ByLikeCountAndDateRangeWithoutDuplicateWinners();
        List<Object[]> eventBoardWinningList = gabowatdagoRepository.findTop3UsersByPostCountIncludingNick();
        System.out.println("=========================eventWinningList==============:" +eventLikeWinningList);
        System.out.println("=========================boardWinningList==============:" + eventBoardWinningList);
        model.addAttribute("poster", eventBoardWinningList);
        model.addAttribute("Winner", eventLikeWinningList);
        model.addAttribute("Event", AllEvent);
        return "public/event/event";
    }

    // ID로 이벤트 가져오기
    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

}
```
***
