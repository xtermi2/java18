![Java CI](https://github.com/xtermi2/java18/workflows/Java%20CI/badge.svg)


# Schedule

- 2022/02/24 Final Release Candidate
- 2022/03/22 General Availability

# Java 18 Features

- [JEP 400:    UTF-8 by Default](https://openjdk.java.net/jeps/400)
    - Specify UTF-8 as the default charset of the standard Java APIs. With this change, APIs that depend upon the default charset will behave consistently across all implementations, operating systems, locales, and configurations.
- [JEP 408:    Simple Web Server](https://openjdk.java.net/jeps/408)
    - Provide a command-line tool to start a minimal web server that serves static files only. No CGI or servlet-like functionality is available. This tool will be useful for prototyping, ad-hoc coding, and testing purposes, particularly in educational contexts.
    - start om cmd with `jwebserver`. By default, the server runs in the foreground and binds to the loopback address and port 8000. By default, files are served from the current directory.
    - The server can also be started via code, see example `SimpleWebServer.java`.
- [JEP 413:    Code Snippets in Java API Documentation](https://openjdk.java.net/jeps/413)
    - Introduce an `@snippet` tag for JavaDoc's Standard Doclet
    - see example `MyApi.java`
    - build javadoc via `./mvnw javadoc:javadoc`
- [JEP 416:    Reimplement Core Reflection with Method Handles](https://openjdk.java.net/jeps/416)
    - Reimplement java.lang.reflect.Method, Constructor, and Field on top of java.lang.invoke method handles. Making method handles the underlying mechanism for reflection will reduce the maintenance and development cost of both the java.lang.reflect and java.lang.invoke APIs.
- [JEP 417:    Vector API (Third Incubator)](https://openjdk.java.net/jeps/417)
    - see example `Scalar.java`
    - update to second incubator: enhancements in response to feedback as well as performance improvements and other significant implementation enhancements.
      - Support the ARM Scalar Vector Extension (SVE) platform.
      - Improve the performance of vector operations that accept masks on architectures that support masking in hardware.
- [JEP 418:    Internet-Address Resolution SPI](https://openjdk.java.net/jeps/418)
    - Define a service-provider interface (SPI) for host name and address resolution, so that java.net.InetAddress can make use of resolvers other than the platform's built-in resolver.
    - see example `AllLocalInetAddressResolverProvider.java`
- [JEP 419:    Foreign Function & Memory API (Second Incubator)](https://openjdk.java.net/jeps/419)
    - Introduce an API by which Java programs can interoperate with code and data outside of the Java runtime. Combination of 2 APIs introduced in previous JDKs:
    - Foreign-Memory Access API (incubator in 14, 15 and 16)
    - Foreign Linker API (incubator in 16)
    - Changes since first incubator
      - Support for more carriers, such as boolean and MemoryAddress, in memory access var handles;
      - A more general dereference API, available in both the MemorySegment and MemoryAddress interfaces;
      - A simpler API to obtain downcall method handles, where passing a MethodType parameter is no longer required;
      - A simpler API to manage temporal dependencies between resource scopes; and
      - A new API to copy Java arrays to and from memory segments.
    - see example `SortExternalOfHeap.java`
    - **TODO** example from jep does not compile / work
- [JEP 420:    Pattern Matching for switch (Second Preview)](https://openjdk.java.net/jeps/420)
    - see example `SwitchPatternMatching.java`
    - TODO
- [JEP 421:    Deprecate Finalization for Removal](https://openjdk.java.net/jeps/421)
    - TODO

##### Other References

- https://openjdk.java.net/projects/jdk/18/
- https://github.com/carldea/panama4newbies