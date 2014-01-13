# MIRROR Spaces SDK API
This SDK provides high-level interfaces for the services of the [MIRROR Spaces Framework (MSF)][1]. It allows developers without deeper knowledge of the XMPP protocol to connect their applications to the MSF with only a few lines of code.

This API specifies the interface to be realized by the platform dependent implementations.

## Build and Deploy
To build the SDK, run the build task with ant:

    $ ant build

To integrate the SDK in your application, add the following JARs provided in the "dist" directory to your classpath:

    jdom-2.0.5.jar
    spaces-sdk-api-1.3.jar

## Usage
Three major handlers are provided to use the MSF:

1. **[ConnectionHandler][2]**
  A handler to establish and manage the connection to the XMPP server.
2. **[SpaceHandler][3]**
  This handler provides a set of methods to manage the spaces you can access.
  There are methods for the access, creation, management, and deletion of
  spaces. For space management operations the application has to be online.
  Retrieving space information is also possible in offline mode, as long as the
  information is available in the handler's cache. 
3. **[DataHandler][4]**
  The data handler provides methods to register for notifications about newly
  published data, and with methods to send and retrieve it. All items published
  and received while being online are stored and therefore also available when
  the handler is offline. Additionally, the allows queries to the [persistence service][5].

The general API description is available here:
http://docs.mirror-demo.eu/spaces-sdk/api/1.3/

## License
The Spaces SDK API is provided under the [Apache License 2.0][6].
License information for third party libraries is provided with the related JAR files.

## Changelog

v1.3 - November 26, 2013

- Added ConnectionHandler.getNetworkInformation() to retrieve information about the services available in the XMPP network.
- Added support for the Common Data Model (CDM) version 2.0.
- DataHandler: Added multiple methods to support the MIRROR Persistence Service.
- DataHandler: Improved client side data object filtering.
- Updated JDOM to version 2.0.5.

v1.2 - April 15, 2013

- Interfaces for model classes (CDMData*, DataModel, DataObject, *Space, SpaceChannel, SpaceMember) now extend the java.io.Serializable interface. 
- Replaced Space.isPersistent() with Space.getPersistenceType() and Space.getPersistenceDuration().
- Added request timeout to connection configuration.
- Added user creation to connection handler.
- Added Space.getPersistenceChannel().

v1.1 - November 7, 2012

- Added ConnectionHandler and related interfaces.
- Added CDMVersion enumeration.
- Replaced ConnectionModeHandler with OfflineModeHandler.
- SpaceHandler: Operations on default spaces return now typed private spaces.
- SpaceHandler: Added method to modify the list of models supported by an organizational space.
- Minor interface changes. 

v1.0 - October 25, 2012

- Added SpaceHandler.deleteSpace().
- Added constants to space handler.
- Compatible to the MIRROR Spaces Service v0.4.x.

v1.0 RC1 - October 23, 2012

- Added clear() to connection mode handler interface.

v1.0 BETA1 - October 16, 2012

- Several fixes.

v1.0 ALPHA1 - September 24, 2012

- Initial version.

  [1]: https://github.com/MirrorIP
  [2]: http://docs.mirror-demo.eu/spaces-sdk/api/1.3/index.html?de/imc/mirror/sdk/ConnectionHandler.html
  [3]: http://docs.mirror-demo.eu/spaces-sdk/api/1.3/index.html?de/imc/mirror/sdk/SpaceHandler.html
  [4]: http://docs.mirror-demo.eu/spaces-sdk/api/1.3/index.html?de/imc/mirror/sdk/DataHandler.html
  [5]: https://github.com/MirrorIP/msf-persistence-service
  [6]: http://www.apache.org/licenses/LICENSE-2.0.html