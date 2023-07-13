package com.mahmutcelik.demo.config;

import com.mahmutcelik.demo.model.Customer;
import com.mahmutcelik.demo.repository.CustomerRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * DATABASE DE KENDİ TABLE IMIZI OLUSTURDUK VE ORADAKİ BİLGİLERİ OKUYUP AUTHENTICATION PROVIDER A VERMEMIZ ICIN KENDI USER DETAILS SERVICE IMIZI YAZMAMIZ GEREKIYOR
 * BUNUN ICIN OLUSTURDUK VE LOADBYUSERNAME METODUNU YAZACAĞIZ
 * */

//Service yaptık ve bu sayede application context te bean i oluşturulmuş oldu. Configteki bean i de sildiğimiz için UserDetailsService i implement eden burası kaldı
//Spring boot otomatik olarak buraya gelir ve UserDetails i alır - tekrardan config içerisinde bean oluşturmamıza gerek yok
@Service
public class EazyBankUserDetails implements UserDetailsService {
    private final CustomerRepository customerRepository;

    public EazyBankUserDetails(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //User da UserDetails i implement eder
    //Öncelikle repo dan email ile user i cekti kontrol etti
    // user varsa UserDetails ta olması gereken username password authority gibi alanları aldı
    //authority için SimpleGrantedAuthority kullandı ve user ın role unu ekledi
    //Bilgilerle yeni User oluşturdu - UserDetails oluşturamaz çünkü interface
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        String username,password = null;
        List<GrantedAuthority> authorities = null;
        List<Customer> customer = customerRepository.findByEmail(email);
        if(customer.isEmpty()){
            throw new UsernameNotFoundException("User details is not correct to find a user"+email);
        }else {
            username = customer.get(0).getEmail();
            password = customer.get(0).getPwd();
            authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(customer.get(0).getRole()));
        }
        return new User(username,password,authorities);
    }
}
