# GitHub Copilot Instructions for FEM_Main

This document provides custom instructions for GitHub Copilot when working on the FEM_Main repository.

## Project Overview

This is a Finite Element Method (FEM) project. When contributing code or providing suggestions, keep in mind:
- Focus on numerical accuracy and computational efficiency
- Consider memory management and performance implications
- Maintain mathematical correctness in algorithms

## Code Style & Formatting

- Follow consistent naming conventions throughout the codebase
- Use descriptive variable names that reflect mathematical or physical meaning (e.g., `stiffnessMatrix`, `nodeCoordinates`)
- Keep functions focused and single-purpose
- Add appropriate whitespace for readability
- Use comments to explain complex mathematical operations or algorithms

## Documentation

- Document all public APIs and functions
- Include docstrings/comments explaining:
  - Purpose and functionality
  - Parameters and their units (if applicable)
  - Return values and their meaning
  - Any mathematical formulations or references
- Update README.md when adding new features or changing functionality
- Document any assumptions or limitations in the code

## Testing

- Write tests for new functionality
- Include edge cases and boundary conditions
- Test numerical accuracy where applicable
- Verify that changes don't break existing functionality
- Consider creating tests for:
  - Input validation
  - Mathematical correctness
  - Performance benchmarks (where relevant)

## Security

- Never commit secrets, API keys, or sensitive credentials
- Validate all user inputs
- Handle file operations safely
- Be cautious with external dependencies
- Follow security best practices for the language/framework in use

## Dependencies

- Keep dependencies minimal and well-justified
- Document why each dependency is needed
- Prefer well-maintained, widely-used libraries
- Consider the license compatibility of dependencies

## Error Handling

- Provide clear, informative error messages
- Handle edge cases gracefully
- Use appropriate exception types
- Log errors appropriately for debugging
- Validate inputs at function boundaries

## Performance Considerations

- Optimize for computational efficiency where appropriate
- Consider memory usage in large-scale computations
- Profile code when making performance-related changes
- Document any performance trade-offs

## Version Control

- Write clear, descriptive commit messages
- Keep commits focused and atomic
- Reference issue numbers in commits when applicable
- Follow conventional commit format when possible (e.g., `feat:`, `fix:`, `docs:`)

## Collaboration

- Be respectful and constructive in code reviews
- Ask questions when requirements are unclear
- Provide context and rationale for changes
- Keep pull requests focused and reasonably sized

## Specific Guidance for FEM Work

- Use standard FEM terminology (nodes, elements, degrees of freedom, etc.)
- Maintain consistency with established FEM conventions
- Consider numerical stability and conditioning
- Be mindful of coordinate systems and transformations
- Document any assumptions about element types or boundary conditions
