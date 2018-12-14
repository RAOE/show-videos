function removeSplitSymbol(str) {
  return str.replace(/^\/(.+)\/$/g, (_match, key) => key);
}

export function join(...pathNames) {
  return pathNames.map(pathName => removeSplitSymbol(pathName)).join("/");
}
