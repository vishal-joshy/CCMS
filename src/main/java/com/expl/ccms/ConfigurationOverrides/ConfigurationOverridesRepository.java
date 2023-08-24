package com.expl.ccms.ConfigurationOverrides;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfigurationOverridesRepository extends JpaRepository<ConfigurationOverride,Long> {
   ConfigurationOverride findAllByGroupIdAndServiceId(Long groupId, Optional<Long> serviceId);
}
