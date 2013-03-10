package org.helgoboss

/**
 * Contains the basic API for building, using and extending a capsule-based DSL along with some default implementations.
 *
 * A capsule-based DSL is a generalization of that one used in the project "Dominoe". Here's an illustrative example
 * for how a capsuled-based DSL might look like:
 *
 * {{{
 * whenTurnedOn {
 *   whenDevicePluggedIn {
 *     lightLED()
 *   }
 * }
 * }}}
 *
 * The documentation distinguishes between 3 types of API clients: End users, capsule providers and context providers.
 * The majority of developers will just come into contact with this API as end users.
 */
package object capsule {

}
