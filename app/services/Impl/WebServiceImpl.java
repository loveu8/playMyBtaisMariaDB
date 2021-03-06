package services.Impl;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import pojo.web.Member;
import pojo.web.MemberDetail;
import pojo.web.MemberToken;
import pojo.web.auth.UserSession;
import pojo.web.email.MemberChangeEmail;
import pojo.web.email.MemberSendChangeEmail;
import pojo.web.signup.request.SignupRequest;
import services.WebService;


public class WebServiceImpl implements WebService {

  @Inject
  private WebService webService;
  
  public WebServiceImpl() throws SQLException {
    // 建立Inject modules.MyBatisModule()
    // 讓WebService藉由 injector 可以跟DB建立連線
    Injector injector = Guice.createInjector(new modules.MyBatisModule());
    this.webService = injector.getInstance(WebService.class);
  }
  
  public int signupNewMember(@Param("signupRequest") SignupRequest signupRequest) {
    return this.webService.signupNewMember(signupRequest);
  }

  public boolean checkMemberByEmail(String email) {
    return this.webService.checkMemberByEmail(email);
  }

  public boolean checkMemberByUsername(String username){
    return this.webService.checkMemberByUsername(username);
  }
  
  public Member findMemberByEmail(String email) {
    return this.webService.findMemberByEmail(email);
  }

  public Member findMemberByEmailAndUserName(@Param("email")String email , @Param("username")String username) {
    return this.webService.findMemberByEmailAndUserName(email , username );
  }
  
  public int genTokenData(@Param("memberToken") Map<String , String> membetToken){
    return this.webService.genTokenData(membetToken);
  }
  
  public int genMemberLoginLog(@Param("memberLoginData") Map<String , String> memberLoginData){
    return this.webService.genMemberLoginLog(memberLoginData);
  }
  
  public MemberToken getMemberTokenData(@Param("token") String token , @Param("type") String type){
    return this.webService.getMemberTokenData(token , type);
  }
  
  public Member findMemberByMemberNo(String memberNo){
    return this.webService.findMemberByMemberNo(memberNo);
  }
  
  public int updateMemberToken(@Param("memberNo") String memberNo , @Param("type") String type){
    return this.webService.updateMemberToken(memberNo,type);
  }
  
  public int updateMemberToAuthOk(String memberNo){
    return this.webService.updateMemberToAuthOk(memberNo);
  }
  
  public int genMemberChangeLog(Member member){
    return this.webService.genMemberChangeLog(member);
  }

  public int genUserSession(UserSession userSession) {
    return this.webService.genUserSession(userSession);
  }

  @Override
  public UserSession getUserSession(String sessionId) {
    return this.webService.getUserSession(sessionId);
  }

  public int updateMemberPassword(@Param("memberNo")String memberNo, @Param("password")String password){
    return this.webService.updateMemberPassword(memberNo , password);
  }

  @Override
  public boolean checkMemberByMemberNoAndPassword(String no, String oldPassword) {
    return this.webService.checkMemberByMemberNoAndPassword(no , oldPassword);
  }

  @Override
  public MemberChangeEmail getMemberEmails(@Param("memberNo") String memberNo) {
    return this.webService.getMemberEmails(memberNo);
  }

  @Override
  public int genMemberSendChangeEmail(MemberSendChangeEmail data) {
    return this.webService.genMemberSendChangeEmail(data);
  }
  
  @Override
  public MemberSendChangeEmail getMemberSendChangeEmailByToken(@Param("token")String token){
    return this.webService.getMemberSendChangeEmailByToken(token);
  }
  
  @Override
  public int updateMemberEmail(@Param("memberNo")String memberNo , @Param("newEmail")String newEmail){
    return this.webService.updateMemberEmail(memberNo , newEmail);
  }
  
  @Override
  public boolean checkMemberDetailByCellphone(@Param("cellphone") String cellphone ){
    return this.webService.checkMemberDetailByCellphone(cellphone);
  }
  
  @Override
  public MemberDetail findMemberDetailByMemberNo(@Param("memberNo") String memberNo ){
    return this.webService.findMemberDetailByMemberNo(memberNo);
  }
  
  @Override
  public int updateMemberUsername(@Param("memberNo") String memberNo, @Param("newUsername") String newUsername){
    return this.webService.updateMemberUsername(memberNo , newUsername);
  }
  
  @Override
  public int genMemberDetail(@Param("data") MemberDetail memberDetail){
    return this.webService.genMemberDetail(memberDetail);
  }
  
  @Override
  public int genMemberDetailChangeLog(@Param("data") MemberDetail memberDetail){
    return this.webService.genMemberDetailChangeLog(memberDetail);
  }
  
}
