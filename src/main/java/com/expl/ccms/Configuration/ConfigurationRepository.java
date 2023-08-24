package com.expl.ccms.Configuration;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConfigurationRepository extends JpaRepository<Configuration,ConfigurationId> {
}
