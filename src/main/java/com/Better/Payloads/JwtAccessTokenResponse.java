package com.Better.Payloads;

import com.Better.Models.Role;
import java.util.Set;

public record JwtAccessTokenResponse (
    String accessToken,
    String firstname,
    String lastname,
    String Email,
    Set<Role> roles
){}
