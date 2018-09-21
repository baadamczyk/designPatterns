package pl.baadamczyk.designpatterns.structural.proxy;

/*
    It's important to use this interface along with implementation instead of implementation only,
    during proxy instantiation.
    In other case, casting the proxy to the implementation will not be possible
*/
public interface CredentialService {

  void setPassword(String newPassword);
}
