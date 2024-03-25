package com.authorizer.authorizer.role;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RoleSeeder implements ApplicationRunner {
    private final RoleRepository roleRepository;
    private static final Logger log = LoggerFactory.getLogger(RoleSeeder.class);

    @Override
    public void run(ApplicationArguments args) {
        if(args.getOptionValues("seeder") != null){
            List<String> seeders = Arrays.asList(args.getOptionValues("seeder").get(0).split(","));
            if (seeders.contains("role")) {
                seedRoles();
                log.info("Role seeder executed successfully");
            }
        } else {
            log.info("Role seeder skipped");
        }
    }

    private void seedRoles() {
        List<String> roles = Arrays.asList("PRODUCT_READ", "PRODUCT_WRITE", "PRODUCT_DELETE", "PRODUCT_UPDATE");

        for (String roleName : roles) {
            Role role = new Role(null, roleName);
            roleRepository.save(role);
            log.info("Role seeded: {}", roleName);
        }
    }
}
