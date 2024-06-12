package hufs.sweepyswipe.controller;

import hufs.sweepyswipe.Dto.AlarmSettingsDto;
import hufs.sweepyswipe.domain.Member;
import hufs.sweepyswipe.repository.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/members/alarm")
public class AlarmSettingsController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping
    public AlarmSettingsDto showAlarmSettings(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("loginMember");

        log.info("member id : {}", member.getId());

        Member findMember = memberRepository.findOne(member.getId());

        AlarmSettingsDto alarmSettingsDto = new AlarmSettingsDto();
        alarmSettingsDto.setEnabled(findMember.isEnabled());
        alarmSettingsDto.setDayOfWeek(findMember.getDayOfWeek());
        alarmSettingsDto.setTime(findMember.getTime());

        return alarmSettingsDto;
    }

    /*
    public String showAlarmSettings(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("loginMember");

        log.info("member id : {}", member.getId());

        Member findMember = memberRepository.findOne(member.getId());
        AlarmSettingsDto alarmSettingsDto = new AlarmSettingsDto();
        alarmSettingsDto.setEnabled(findMember.isEnabled());
        alarmSettingsDto.setDayOfWeek(findMember.getDayOfWeek());
        alarmSettingsDto.setTime(findMember.getTime());

        model.addAttribute("alarmSettingsDto", alarmSettingsDto);

        return "alarmSettings";
    }
     */

    @PostMapping
    @Transactional
    public String updateAlarmSettings(HttpServletRequest request, @RequestBody AlarmSettingsDto alarmSettingsDto) {
        HttpSession session = request.getSession();
        Member sessionMember = (Member) session.getAttribute("loginMember");

        Member existingMember = memberRepository.findOne(sessionMember.getId());

        existingMember.setEnabled(alarmSettingsDto.isEnabled());
        existingMember.setDayOfWeek(alarmSettingsDto.getDayOfWeek());
        existingMember.setTime(alarmSettingsDto.getTime());

        session.setAttribute("loginMember", existingMember);

        return "redirect:http://localhost:3000/settings";

    }
    /*
    public String updateAlarmSettings(HttpServletRequest request, @ModelAttribute("alarmSettingsDto") AlarmSettingsDto alarmSettingsDto) {
        HttpSession session = request.getSession();
        Member sessionMember = (Member) session.getAttribute("loginMember");

        Member existingMember = memberRepository.findOne(sessionMember.getId());

        existingMember.setEnabled(alarmSettingsDto.isEnabled());
        existingMember.setDayOfWeek(alarmSettingsDto.getDayOfWeek());
        existingMember.setTime(alarmSettingsDto.getTime());

        session.setAttribute("loginMember", existingMember);

        return "redirect:/members/alarm";

    }

     */
}
