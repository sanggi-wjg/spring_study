package com.example.spring_study.member;

import com.example.spring_study.member.dto.MemberDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class MemberService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MemberEntity> byUsername = memberRepository.findByUsername(username);
        MemberEntity findMember = byUsername.orElseThrow(() -> new UsernameNotFoundException(username));

        return new User(findMember.getUsername(), findMember.getPassword(), authorities());
    }

    private Collection<? extends GrantedAuthority> authorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    public MemberEntity createUser(String username, String password) {
        MemberEntity member = new MemberEntity();
        member.setUsername(username);
        member.setPassword(passwordEncoder.encode(password));
        return memberRepository.save(member);
    }

    @Transactional
    public boolean isExistMemberByUsername(String username) {
        Optional<MemberEntity> byUsername = memberRepository.findByUsername(username);
        return byUsername.isPresent();
    }

    @Transactional
    public Page<MemberDTO> findAllByPage(Pageable pageable) {
        Page<MemberEntity> memberEntities = memberRepository.findAll(pageable);
        return memberEntities.map(new Function<MemberEntity, MemberDTO>() {
            @Override
            public MemberDTO apply(MemberEntity memberEntity) {
                return MemberDTO.builder()
                        .username(memberEntity.getUsername())
                        .build();
            }
        });
    }

}
