package io.github.oliviercailloux.plaquette_mido_soap;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Optional;

/**
 * <p>
 * Immutable.
 * </p>
 * <p>
 * Stores two optional pieces of login information: username and password. For
 * each piece, distinguishes <em>missing information</em> and <em>empty
 * string</em>. An empty string is thus considered as an information: one might
 * wish to indicate that the username is the empty string, or the password is
 * the empty string, or both, and this is distinguished from the case where the
 * information has not been specified at all. For example, if an environment
 * variable MY_NAME must be configured to set the username, this class permits
 * to distinguish the variable being set to an empty value and the variable
 * being not set.
 * </p>
 * <p>
 * A missing piece of information is represented by an empty optional (not to be
 * mixed with a present optional containing an empty string).
 * </p>
 */
class LoginPublic {

	public static LoginPublic given(String username, String password) {
		LoginPublic authentication = new LoginPublic(Optional.of(username), Optional.of(password));
		return authentication;
	}

	public static LoginPublic onlyUsername(String username) {
		LoginPublic authentication = new LoginPublic(Optional.of(username), Optional.empty());
		return authentication;
	}

	public static LoginPublic onlyPassword(String password) {
		LoginPublic authentication = new LoginPublic(Optional.empty(), Optional.of(password));
		return authentication;
	}

	public static LoginPublic empty() {
		LoginPublic authentication = new LoginPublic(Optional.empty(), Optional.empty());
		return authentication;
	}

	private final Optional<String> username;
	private final Optional<String> password;

	private LoginPublic(Optional<String> username, Optional<String> password) {
		this.username = checkNotNull(username);
		this.password = checkNotNull(password);
	}

	public Optional<String> getUsername() {
		return username;
	}

	public Optional<String> getPassword() {
		return password;
	}

	/**
	 * <p>
	 * Returns the number of pieces of information which are not missing.
	 * </p>
	 * <p>
	 * Note that an empty string counts as valuable information.
	 * </p>
	 *
	 * @return 0, 1 or 2.
	 */
	public int getInformationalValue() {
		return (username.isPresent() ? 1 : 0) + (password.isPresent() ? 1 : 0);
	}
}