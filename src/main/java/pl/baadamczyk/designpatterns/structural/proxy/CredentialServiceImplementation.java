package pl.baadamczyk.designpatterns.structural.proxy;

/*
  This is an implementation of CredentialService. This type will be passed to proxy to create
*/
public class CredentialServiceImplementation implements CredentialService {

  @Override
  public void setPassword(String newPassword) {
    System.out.println("SETTING PASSWORD TO: " + newPassword);
  }
}
