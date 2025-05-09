package org.springframework.samples.petclinic.owner;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class OwnerUserDetailsService implements UserDetailsService {

	private final OwnerRepository ownerRepository;

	public OwnerUserDetailsService(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return ownerRepository.findByEmail(email)
			.orElseThrow(() -> new UsernameNotFoundException("Owner not found"));
	}
}
