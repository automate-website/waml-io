# waml-io Change Log
All notable changes to this project will be documented in this file.
This project adheres to [Semantic Versioning](http://semver.org/).

## [Unreleased]

## [1.0.0]
### Changed
- store step inherits filter step nature.

## [0.7.0]

### Added
- experimental support for store criteria on element filter steps to be able to store the element reference and access it in other steps during scenario execution

## [0.6.1]
## Fixed
- ensured backwards compatibility of the model

## [0.6.0]
### Added
- added short notation support for filter parent criteria

## [0.5.2]
### Fixed
- short notation conditions for enter and ensure steps

## [0.5.1]
### Fixed
- made ensure an explicit action since it requires interaction with the browser.

## [0.5.0]
### Added
- added utility methods to distinguish between explicit and implicit steps.

## [0.4.0]
### Changed
- improved exception handling and wording

## [0.3.1]
### Fixed
- fixed action short notation check

## [0.3.0]
### Added
- added metadata criterion for scenario and action for metadata data transport

## [0.2.1]
### Changed
- centralized action type lookup

## [0.2.0]
### Changed
- removed criterion value wrapper that was encapsulating different types in favor of simplicity

## [0.1.2]
### Fixed
- criterion value of method must not wrap null values with an object

## [0.1.1]
### Fixed
- fixed accidental build of a fat artifact

## [0.1.0]
### Added
- initial implementation

[0.1.0]: https://github.com/automate-website/waml-io/commits/0.1.0
[0.1.1]: https://github.com/automate-website/waml-io/compare/0.1.0...0.1.1
[0.1.2]: https://github.com/automate-website/waml-io/compare/0.1.1...0.1.2
[0.2.0]: https://github.com/automate-website/waml-io/compare/0.1.2...0.2.0
[0.2.1]: https://github.com/automate-website/waml-io/compare/0.2.0...0.2.1
[0.3.0]: https://github.com/automate-website/waml-io/compare/0.2.1...0.3.0
[0.3.1]: https://github.com/automate-website/waml-io/compare/0.3.0...0.3.1
[0.4.0]: https://github.com/automate-website/waml-io/compare/0.3.1...0.4.0
[0.5.0]: https://github.com/automate-website/waml-io/compare/0.4.0...0.5.0
[0.5.1]: https://github.com/automate-website/waml-io/compare/0.5.0...0.5.1
[0.5.2]: https://github.com/automate-website/waml-io/compare/0.5.1...0.5.2
[0.6.0]: https://github.com/automate-website/waml-io/compare/0.5.1...0.6.0
[0.6.1]: https://github.com/automate-website/waml-io/compare/0.6.0...0.6.1
[0.7.0]: https://github.com/automate-website/waml-io/compare/0.6.1...0.7.0
[1.0.0]: https://github.com/automate-website/waml-io/compare/0.7.0...1.0.0
[Unreleased]: https://github.com/automate-website/waml-io/compare/1.0.0...master
