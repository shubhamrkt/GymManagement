package com.gym.phoenixgym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gym.phoenixgym.entity.Member;
import com.gym.phoenixgym.service.MemberService;


@CrossOrigin
@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/getallusers")
	public List<Member> getAllMembers(Member member){	
		return memberService.getAllMember();	
	}
	
	@PostMapping("/forget")
	public List<Member> forgetPassword(@RequestBody Member member){
		return memberService.forgetPassword(member.getEmail(), member.getSecurityQues(), member.getSecurityAns());
	}
	
	@PostMapping("/findbyphone")
	public List<Member> findByPhone(@RequestBody Member member) {
		return memberService.findByPhone(member.getPhone());
	}
	@PostMapping("/findbyemail")
	public List<Member> findByEmail(@RequestBody Member member) {
		return memberService.findByEmail(member.getEmail());
	}
	
	@PostMapping("/login")
	public List<Member> getUserByEmailAndPassword(@RequestBody Member member){
		return memberService.getUMemberByEmailAndPassword(member.getEmail(), member.getPassword());
		}
	@PostMapping("/register")
	public Member insertMember(@RequestBody Member member) {
		return memberService.insertMember(member);
	}
	@PutMapping("/updatepassword")
	public Member updatePassword(@RequestBody Member member) {
		return memberService.updatePassword(member);
	}
	
	@DeleteMapping("deleteuser/{uemail}")
	public String deleteMember(@PathVariable String uemail) {
		memberService.deleteMember(uemail);
		return "Deleted";
	}
	
	
}
