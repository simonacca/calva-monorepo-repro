# How the repo is structured

The repo has a top level *"libs"* folder containing units of reusable code. Each lib
has its own `deps.edn`.

The repo also has top level *"projects"* folders (in this case just `project` but you can imagine multiple ones)
which represent units of deployment (i.e. an "application" that one might want to actually compile,package and deploy on its own).

To provide a more ergonomic view on an otherwise unwieldy repo, 
each project folder has a vscode workspace file with many values in the `folders` entry,
listing the project folder itself and all libraries relevant to the current project.
See `project1/project1.code-workspace` for example.

# Expected behavior

As of calva `2.0.333`, if we either:
- manually start the LSP server in the repo root
- add `"calva.enableClojureLspOnStart": "when-file-opened-use-furthest-project"` to a workspace (like the one listed above)

The whole repo is "covered" by the LSP, meaning that one can for example:

- open `project1/src/mycorp/project1/core.clj`
- move the cursor to `mycorp.lib2.core`
- get all usual LSP functionality on all symbols in this namespace
- hit "jump to definition" in vscode
- get to `libs/lib2/src/mycorp/lib2/core.clj`
- get all usual LSP functionality on all symbols in this namespace
- get to `libs/lib1/src/mycorp/lib1/core.clj`
- get all usual LSP functionality on all symbols in this namespace

# Observed behavior

As of calva `2.0.334`, if we either:
- manually start the LSP server in the repo root
- add `"calva.enableClojureLspOnStart": "when-file-opened-use-furthest-project"`

No LSP server functionality is available in any of the namespaces.

Switching back to `2.0.333` restores functionality.
