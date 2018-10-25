# solid-java-client
A Java client for authenticating and communicating with Solid POD's. This client can be used
to retrieve a POD's public profile. This client is still in early development, please do not use
it in a production environment. As the Solid spec. matures this client will be updated to offer
newly defined features.

## Getting started

This client is not yet published. But feel free to clone this repo. and run the unit tests
to see how it works.

## Functionality

1. Full public profile.

## Usage

```Java

final SolidClient client = new SolidClient("https", "solid.community", "/login/password", "crmepham2", "testing");
final Person me = client.me();
final String name = me.getName();
final Set<Person> friends = me.getKnows();

StringBuilder builder = new StringBuilder();
builder.append("Welcome to this app " + name + "\n");

if (!friends.isEmpty()) {

    builder.append("Friends list:\n");

    friends.forEach(f -> builder.append(f.getName() + "\n"));
}

System.out.println(builder.toString());

```

